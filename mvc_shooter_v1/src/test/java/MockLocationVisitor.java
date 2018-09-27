
import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.objects.cannon.Cannon;
import cz.fit.dpo.mvcshooter.model.objects.enemy.Enemy;
import cz.fit.dpo.mvcshooter.model.objects.missile.Missile;
import cz.fit.dpo.mvcshooter.model.objects.objects;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Анастасия
 */
public class MockLocationVisitor implements Visitor {
    private Coordinates location;

    public Coordinates getLocation() {
        return location;
    }

    public void setLocation(Coordinates location) {
        this.location = location;
    }

    @Override
    public void visitCannon(Cannon cannon) {
        visitObjects(cannon);
    }

    @Override
    public void visitSimpleEnemy(Enemy enemy) {
        visitObjects(enemy);
    }

    @Override
    public void visitRealisticEnemy(Enemy enemy) {
        visitObjects(enemy);
    }

    @Override
    public void visitMissile(Missile missile) {
        visitObjects(missile);
    }

    @Override
    public void visitObjects(objects objects) {
        location = new Coordinates(objects.location);
    }

    @Override
    public void visitSuperEnemy(Enemy enemy) {
        visitObjects(enemy);
    }

    @Override
    public void visitBossEnemy(Enemy enemy) {
        visitObjects(enemy);
    }

    
}
