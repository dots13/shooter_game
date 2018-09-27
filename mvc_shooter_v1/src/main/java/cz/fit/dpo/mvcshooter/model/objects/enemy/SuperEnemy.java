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
public class SuperEnemy extends Enemy {
    
    
    public SuperEnemy(Coordinates field) {
        super(field);
        livePoint = 2;        
    }

    protected SuperEnemy() {}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSuperEnemy(this);
    }

    @Override
    public synchronized boolean move(Coordinates battlefield, double gravity) {
        this.mooving.addX((Math.random() * 0.2 - 0.1));
        this.mooving.addY((Math.random() * 0.2 - 0.1));
        return super.move(battlefield, gravity);
    }

    @Override
    public Enemy clone() {
        SuperEnemy enemy = new SuperEnemy();
        enemy.setAs(this);
        return enemy;
    }
    
}
