/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.factory;

import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.objects.enemy.Enemy;
import cz.fit.dpo.mvcshooter.model.objects.missile.Missile;
import cz.fit.dpo.mvcshooter.model.objects.missile.strategy.MissileStrategy;

/**
 *
 * @author Анастасия
 */
public abstract class AbstractObjFactory {
    protected Coordinates field;
    protected MissileStrategy strategy;

    public AbstractObjFactory(Coordinates field) {
        this.field = field;
    }

    public abstract Enemy createEnemy();
    public abstract Enemy createSuperEnemy();

    public abstract Missile createMissile(Coordinates from, double angle, int power);   
}
