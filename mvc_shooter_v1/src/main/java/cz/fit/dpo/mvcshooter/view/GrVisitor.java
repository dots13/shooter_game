/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.objects.cannon.Cannon;
import cz.fit.dpo.mvcshooter.model.objects.enemy.*;
import cz.fit.dpo.mvcshooter.model.objects.enemy.SimpleEnemy;
import cz.fit.dpo.mvcshooter.model.objects.missile.Missile;
import cz.fit.dpo.mvcshooter.model.objects.objects;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 *
 * @author Анастасия
 */
public class GrVisitor implements Visitor {
    private Coordinates location;
    private Coordinates size;
    private GraphicsDrawer.Image image;
    private double angle;

    @Override
    public void visitCannon(Cannon cannon) {
        visitObjects(cannon);
        image = GraphicsDrawer.Image.CANNON;
    }

    @Override
    public void visitMissile(Missile missile) {
        visitObjects(missile);
        image = GraphicsDrawer.Image.MISSILE;
    }

    @Override
    public void visitObjects(objects gameObject) {
        location = gameObject.getCenter();
        size = gameObject.getSize();
        angle = gameObject.getAngle();
    }

    @Override
    public void visitSimpleEnemy(Enemy enemy) {
        visitObjects(enemy);
        image = GraphicsDrawer.Image.ENEMY1;
    }

    @Override
    public void visitRealisticEnemy(Enemy enemy) {
        visitObjects(enemy);
        image = GraphicsDrawer.Image.ENEMY2;
    }

    public Coordinates getLocation() {
        return location;
    }

    public Coordinates getSize() {
        return size;
    }

    public GraphicsDrawer.Image getImage() {
        return image;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public void visitSuperEnemy(Enemy enemy) {
        visitObjects(enemy);
        image = GraphicsDrawer.Image.ENEMY3;}
    public void visitBossEnemy(Enemy enemy) {
        visitObjects(enemy);
        image = GraphicsDrawer.Image.ENEMY_BOSS;}
}
