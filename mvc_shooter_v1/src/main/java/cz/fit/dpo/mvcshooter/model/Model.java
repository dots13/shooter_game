/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model;


import cz.fit.dpo.mvcshooter.sounds.Sound.*;
import cz.fit.dpo.mvcshooter.model.objects.cannon.Cannon;
import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.factory.AbstractObjFactory;
import cz.fit.dpo.mvcshooter.model.objects.enemy.Enemy;
import cz.fit.dpo.mvcshooter.model.objects.enemy.BossEnemy;
import cz.fit.dpo.mvcshooter.model.objects.missile.Missile;
import cz.fit.dpo.mvcshooter.model.objects.objects;
import cz.fit.dpo.mvcshooter.model.observer.Subject;
import cz.fit.dpo.mvcshooter.memento.Memento;
import cz.fit.dpo.mvcshooter.memento.Originator;
import cz.fit.dpo.mvcshooter.model.factory.RealisticObjFactory;
import cz.fit.dpo.mvcshooter.model.factory.SimpleObjFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

//import sun.security.ssl.TrustManagerFactoryImpl.SimpleFactory;

/**
 *
 * @author Анастасия
 */
public class Model extends Subject {
    private double gravity;
    private Coordinates field;
    private Cannon cannon;
    private int score; //
    private int shoot; //
    private int level;
    private int time =0;
    private List<Missile> missile;
    private List<Enemy> enemies;
    private boolean sg = false;
    private Memento saved;
    
    private AbstractObjFactory objFactory;
    private Mode mode;
    
    public static enum Mode {
        REALISTIC,
        SIMPLE
    }
    
    public Model() {
        this.gravity = 1;
        this.field = new Coordinates(1000, 600);
        this.missile = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.cannon = new Cannon(field);
        this.score = 1;
        this.level = 1;
        this.shoot = 0;
        this.mode = Mode.REALISTIC;
        applyMode();
        for (int i = 0; i < 10; ++i) {
           this.enemies.add(objFactory.createEnemy());
        }
    }
    
    public void saveGame() {
        saved = createMemento();
        System.out.println("Game saved!");
    }
    public void loadGame() {
        if (saved != null) {
            setMemento(saved);
            notifyObservers();
        } else {
            System.out.println("No saved game");
        }
    }
    ///////// MEMENTO ///////////
    public void setMemento(Memento memento) {
        Originator originator = memento.getOriginator();
    //    ;
  
        gravity = (double) originator.getGravity();
        enemies = originator.getEnemies();
        mode = originator.getMode();
        score = originator.getScore();
        level= originator.getLevel();
    //    time = originator.getTime();
        
        applyMode();
    }
    
    
    public Memento createMemento() {
        Originator originator = new Originator();
        originator.setEnemies(enemies.stream().map((e) -> e.clone()).collect(Collectors.toList()));
        originator.setGravity((int) gravity);
        originator.setMode(mode);
        originator.setScore(score);
        originator.setLevel(level);
        
        return new Memento(originator);
    }
    
        
    public void resetObjects(boolean resetScoe) {
        missile.clear();
        enemies.clear();
        if (resetScoe){
            level = 0;
            score = 0;
        }
        notifyObservers();
    }
    
    
    public void spawnEnemy() {
        enemies.add(objFactory.createEnemy());
        notifyObservers();
    }
    ////
    public void fire(int firePower) {
        if (this.missile.size()<11){
        if (this.score % 10 == 0) {
            String stateVal = getCannon().getState();
            getCannon().setSuperState();
            this.missile.addAll(getCannon().fire(firePower));
            getCannon().setState(stateVal);
        }
        else
           this.missile.addAll(getCannon().fire(firePower)); 
        }     
    }
    public void startShooting() {
        this.shoot = 1;
    }
    public void releaseShooting() {
        fire(shoot);
        shoot = 0;
    } 
    //////
    private void applyMode() {
        if (mode == Mode.SIMPLE) {
            turnSimple();
        } else {
            turnRealistic();
        }
    }
    public void swapMode() {
        if (mode == Mode.REALISTIC) {
            mode = Mode.SIMPLE;
        } else {
            mode = Mode.REALISTIC;
        }
        applyMode();
        notifyObservers();
    }
    public void setSimpleMode() {
        mode = Mode.SIMPLE;
        applyMode();
        notifyObservers();
    }
    public void setRealisticMode() {
        mode = Mode.REALISTIC;
        applyMode();
        notifyObservers();
    }
 //////////////////////////
    
    public void swapCannon() {
        getCannon().swapStates();
    }
    
    public void singleCannon() {
        getCannon().setSingleState();
    }
    
    public void doubleState() {
        getCannon().setDoubleState();
    }
    
    private void turnRealistic() {
        this.objFactory = new RealisticObjFactory(field);
        this.getCannon().setFactory(objFactory);
    }

    private void turnSimple() {
        this.objFactory = new SimpleObjFactory(field);
        this.getCannon().setFactory(objFactory);
    }
    
    public Coordinates getField() {
        return field;
    }

    public void addGravity(int value) {
        gravity += value;
        notifyObservers();
    }
    public double getGravity() {
        return gravity;
    }
    public Cannon getCannon() {
        return cannon;
    }
 // shooting

    public void clearShooting() {
        shoot = 0;
    }
    public int getShooting() {
        return shoot;
    }  
    
    public int countEnemy() {
        return enemies.size();
    }    
    public String getLevel() {
        String str = "LEVEL " + level;
        return str;
    }
    ////////////////////////////////////////////////////////////////////////////
    public synchronized List<objects> getObjects() {
        List<objects> obj = new ArrayList<>(missile);
        obj.addAll(enemies);
        obj.add(getCannon());
        return obj;
    }
    private void bossDied() {        
        enemies.clear();
        for (int i = 0; i < 10; ++i) {
            this.enemies.add(objFactory.createSuperEnemy());
            enemies.get(i).setLocation(750, 250);
        }        
    }
    
    private boolean removeAddObjects() {
        List<Missile> missileToRemove = new ArrayList<>();
        for (Missile m : missile) {
            if (m.outOfField(field)) {
                missileToRemove.add(m);
            }
        }

        List<Enemy> enemiesToRemove = new ArrayList<>();
        List<Enemy> enemiesToRemoveOut = new ArrayList<>();
        
        for (Enemy e : enemies) {
            if (!e.outOfField(field)) {
            } else {
                enemiesToRemoveOut.add(e);
            }
        }

        for (Missile m : missile) {
            for (Enemy e : enemies) {
                if (m.collides(e)) {
                   //Sound.playSound("microb_light.aif");
                   e.setLivePoint(1);
                   if ((e.getLivePoint() <= 0)){ 
                       if (!e.getBoss()) {
                            Sound.playSound("cook.aif");
                            missileToRemove.add(m);
                            enemiesToRemove.add(e);
                            score++;
                        } else {
                           score++;
                           enemies.clear();
                           bossDied();
                           break;
                       }
                   } else {
                           
                       Sound.playSound("snow.aif");
                       missileToRemove.add(m);
                       score++;
                    }
                }
            }
        }
        enemies.removeAll(enemiesToRemove);
        enemies.removeAll(enemiesToRemoveOut);
        missile.removeAll(missileToRemove);
        for (int i = 0; i < enemiesToRemoveOut.size(); ++i) {
            this.enemies.add(objFactory.createEnemy());
        }
        return (missileToRemove.size() + enemiesToRemove.size()) != 0;
    }
    public int getScore() {
        return score;
    }

    ///////////////////////////////////////////////////////////////////////////
    public String infoText() {
        String msg = "";
        msg += ", Gravity: " + (double) Math.round(gravity );
        msg += "\n";

        return msg;
    }
    public boolean endOfGame() {
        if (this.level>=10){
            return true;
        }
        else
            return false;
    }

    public void tick() {
        //Sound.playSound("microb_light.aif");
        boolean changed = false;
        if ((this.enemies.isEmpty())&& (mode == Mode.REALISTIC)) {
            missile.clear();
            level++;    
            for (int i = 0; i < 11-level ; ++i) {
                this.enemies.add(objFactory.createEnemy());
             }
            for (int i = 0; i < level ; ++i) {
                this.enemies.add(objFactory.createSuperEnemy());
             }
            if (level%5 == 0)
            {
                Enemy eb = new BossEnemy(this.field);
                this.enemies.add(eb);
            }
        }
        if ((this.enemies.isEmpty())&& mode == Mode.SIMPLE) {
            level++;    
            for (int i = 0; i < 10 ; ++i) {
                this.enemies.add(objFactory.createEnemy());
            notifyObservers();
            }
        }
        if (this.enemies.size()>15) {
            level = 0;
            score = 1;
            this.enemies.clear();
        }
        if (this.level >= 10) {
            level = 10;
            enemies.clear();
        }
        time++;
  
        if ((time + 30* level > 500)) {
            this.enemies.add(objFactory.createEnemy());
            if ((level>3) && (mode == Mode.REALISTIC))
                this.enemies.add(objFactory.createSuperEnemy());
            time = 0;
        }

             
        ////////////////////////////////////////////////////////////////////////
        ////// Mooving logic
        ////////////////////////////////////////////////////////////////////////
        
        for (Missile m : missile) {
            for (Enemy e : enemies) {
                if (e.attention(m)) {
                    e.changeMove(field, gravity);
                }
            }
        }
        for (Enemy e : enemies) {
            for (Enemy e2 : enemies) {
                if (e.attention(e2) && !e.getBoss()) {
                    e.changeMove(field, gravity);
                }
            }
        }
        for (Enemy e : enemies) {
            if (!e.outOfFieldEnemy(field)) {
            } else {
                if (e.outOfFieldX(field))
                    e.borderMoveX(field, gravity);
                if (e.outOfFieldY(field))
                    e.borderMoveY(field, gravity);
            }
        }
        for (objects o : getObjects()) {
            changed |= o.move(field, gravity);
        }
        ////////////////////////////////////////////////////////////////////////
        // remove projectiles and enemies, replanish enemies
        ////////////////////////////////////////////////////////////////////////
        changed |= removeAddObjects();
        
        if ((shoot != 0) &&(shoot < 25)) {
            shoot++;
        }

        if (changed) {
            notifyObservers();
        }
    }
     public String GetText() {
        String msg = "";

        msg += getCannon().getUserMsg();
     //   msg += "\n";
     //   msg += "\n";

        if (mode == Mode.REALISTIC) {
            msg += " Realistic mode";
        } else if (mode == Mode.SIMPLE) {
            msg += " Simple mode";
        }
        msg += ", Gravity: " + (float) Math.round(gravity * 10) / 10;
      //  msg += "\n";
        msg += "\n";
        msg += "Firepower: ";
        for (int i = 0; i < shoot; i++) {
            msg += "|||";
        }
        msg += "\n";
        return msg;
    }
    
}
