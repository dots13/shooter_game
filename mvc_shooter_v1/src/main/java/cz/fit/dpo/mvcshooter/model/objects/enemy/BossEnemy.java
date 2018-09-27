/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.objects.enemy;

import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 *
 * @author Анастасия
 */
public class BossEnemy extends Enemy {
    
    
    public BossEnemy(Coordinates field) {
        super(field);
        livePoint = 10;  
        size.setX(100);
        size.setY(100);
        location.setX(field.getX()/2);
        location.setY(field.getY()/2);
        boss = true;
    }

    public BossEnemy() {}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBossEnemy(this);
    }

    @Override
    public synchronized boolean move(Coordinates battlefield, double gravity) {
        this.mooving.addX((Math.random() * 0.2 - 0.1));
        this.mooving.addY((Math.random() * 0.2 - 0.1));
        return super.move(battlefield, gravity);
    }

    @Override
    public Enemy clone() {
        BossEnemy enemy = new BossEnemy();
        enemy.setAs(this);
        return enemy;
    }
}
