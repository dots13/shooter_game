/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.memento;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.objects.cannon.Cannon;
import cz.fit.dpo.mvcshooter.model.objects.enemy.Enemy;
import cz.fit.dpo.mvcshooter.model.objects.missile.Missile;
import java.util.List;

/**
 *
 * @author Анастасия
 */
public class Originator {
 //   private Cannon cannon;
    private double gravity;
    private List<Missile> missile;
    private List<Enemy> enemies;
    private Model.Mode mode;
    private int score;
    private int shoot;
    private int level;
    private int time;

   // private Coordinates field;
    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    public int getShoot() {
        return shoot;
    }

    public void setShoot(int shoot) {
        this.shoot = shoot;
    }
    
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }


    public double getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }


    public Model.Mode getMode() {
        return mode;
    }

    public void setMode(Model.Mode mode) {
        this.mode = mode;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
