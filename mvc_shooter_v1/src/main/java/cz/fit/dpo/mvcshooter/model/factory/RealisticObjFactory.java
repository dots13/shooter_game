/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.factory;

import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.objects.enemy.Enemy;
import cz.fit.dpo.mvcshooter.model.objects.enemy.RealisticEnemy;
import cz.fit.dpo.mvcshooter.model.objects.enemy.SuperEnemy;
import cz.fit.dpo.mvcshooter.model.objects.missile.Missile;
import cz.fit.dpo.mvcshooter.model.objects.missile.strategy.RealisticStrategy;

/**
 *
 * @author Анастасия
 */
public class RealisticObjFactory extends AbstractObjFactory {

    public RealisticObjFactory(Coordinates field) {
        super(field);
        strategy = new RealisticStrategy();
    }

    @Override
    public Enemy createEnemy() {
        return new RealisticEnemy(field);
    }
    public Enemy createSuperEnemy() {
        return new SuperEnemy(field);
    }

    @Override
    public Missile createMissile(Coordinates start, double angle, int power) {
        return new Missile(start, angle, power, strategy);
    }
    
}
