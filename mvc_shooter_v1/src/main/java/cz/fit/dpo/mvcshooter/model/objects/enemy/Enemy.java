/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.objects.enemy;

import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.objects.objects;

/**
 *
 * @author Анастасия
 */
public abstract class Enemy extends objects {

    int livePoint;
    boolean boss;
    public Enemy (Coordinates field) {
        size.setX(55);
        size.setY(50);
        this.location.setX(60+(Math.random() * (field.getX() - 90)));
        this.location.setY(40+ (Math.random() * (field.getY() - 90)));
        this.livePoint = 1;
        bounded = false;
        boss = false;
    }
    
    protected Enemy() {}
    public boolean getBoss() {
        return boss;
    }

    public Enemy(Enemy enemy) {
        this.location = new Coordinates(enemy.location);
        this.size = new Coordinates(enemy.size);
        this.bounded = enemy.bounded;
        this.livePoint = enemy.livePoint;
        this.mooving = new Coordinates(enemy.mooving);
        this.boss = enemy.boss;
    }

    @Override
    abstract public Enemy clone();

    @Override
    public synchronized boolean move(Coordinates field, double gravity) {
        return super.move(field, gravity);
    } 
        public int getLivePoint() {
        return livePoint;
    }
    public void setLivePoint(int i) {
        this.livePoint = livePoint - i;
    }
    
    public void setLocation(Coordinates newLocation) {
        this.location = newLocation;
    }
    public void setLocation(int x, int y) {
        this.location.setX(x);
        this.location.setY(y);
    }
    
}
