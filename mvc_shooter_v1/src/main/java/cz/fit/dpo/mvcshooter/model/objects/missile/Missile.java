/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.objects.missile;

import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.objects.missile.strategy.MissileStrategy;
import cz.fit.dpo.mvcshooter.model.objects.objects;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 *
 * @author Анастасия
 */
public class Missile extends objects {
    MissileStrategy strategy;
    
    public Missile(Coordinates start, double angel, int power, MissileStrategy strategy) {
        super();
        size.setX(60);
        size.setY(60);
        location = new Coordinates(start);
        mooving.setX(power*Math.cos(angel));
        mooving.setY(power*Math.sin(angel));
        bounded = false;
        this.strategy = strategy;
    }
    private Missile() {}
    
    
    @Override
    public Missile clone() {
        Missile missile = new Missile();
        missile.setAs(this);
        missile.strategy = this.strategy;
        return missile;        
    }
    
    
    @Override
    public synchronized boolean move(Coordinates field, double gravity) {
        this.mooving.add(strategy.getDirection(gravity));
        
        turn((float) (Math.random())*2);
        return super.move(field, gravity);
    }

    
    @Override
    public void accept(Visitor visitor) {
        visitor.visitMissile(this);
    }
    
}
