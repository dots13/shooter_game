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
public class SimpleEnemy extends Enemy {

    public SimpleEnemy(Coordinates field) {
        super(field);
    }

    protected SimpleEnemy() {}

    /**
     *
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitSimpleEnemy(this);
    }

    @Override
    public Enemy clone() {
        SimpleEnemy enemy = new SimpleEnemy();
        enemy.setAs(this);
        return enemy;
    }  
}
