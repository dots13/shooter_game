/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.visitor;

import cz.fit.dpo.mvcshooter.model.objects.cannon.Cannon;
import cz.fit.dpo.mvcshooter.model.objects.enemy.Enemy;
import cz.fit.dpo.mvcshooter.model.objects.missile.Missile;
import cz.fit.dpo.mvcshooter.model.objects.objects;

/**
 *
 * @author Анастасия
 */
public interface Visitor {
    public void visitCannon(Cannon cannon);
    public void visitSimpleEnemy(Enemy enemy);
    public void visitRealisticEnemy(Enemy enemy);
    public void visitMissile(Missile missile);
    public void visitObjects(objects objects);    

    public void visitSuperEnemy(Enemy enemy);

    public void visitBossEnemy(Enemy enemy);
}
