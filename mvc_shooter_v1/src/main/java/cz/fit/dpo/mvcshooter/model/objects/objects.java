/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.objects;

import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;
import cz.fit.dpo.mvcshooter.model.visitor.VisitorElement;

/**
 *
 * @author Анастасия
 */
public class objects implements VisitorElement {
    public Coordinates location;
    protected Coordinates mooving;
    public Coordinates size;
    protected boolean bounded = true;
    protected double angle =0;
    
    
    public objects(){
        location = new Coordinates(0,0);
        size = new Coordinates(0,0);
        mooving = new Coordinates(0,0);

    }
    public synchronized Coordinates getCenter() {
        return new Coordinates(location.getX() - size.getX() / 2, location.getY() - size.getY() / 2);
    }
    public Coordinates getLocation() {
        return location;
    }
    public void turn(double value) {
        value /= 10;
        this.angle += value;
    }
    public Coordinates getSize() {
        return size;
    }
    public double getAngle() {
        return angle;
    }
        
    public boolean outOfField(Coordinates battlefield) {
        return location.getX() > battlefield.getX() || location.getX() < 0 || location.getY() > battlefield.getY() || location.getY() < 0;
    }
    public boolean outOfFieldEnemy(Coordinates battlefield) {
        return location.getX() > (battlefield.getX() - size.getX()) || location.getX() < size.getX() || location.getY() > (battlefield.getY()-size.getY()) || location.getY() < size.getY();
    }
    public boolean outOfFieldX(Coordinates battlefield) {
        return location.getX() > (battlefield.getX() - size.getX()) || location.getX() < size.getX();
    }
    public boolean outOfFieldY(Coordinates battlefield) {
        return location.getY() > (battlefield.getY()-size.getY() -30) || location.getY() < size.getY() + 30;
    }
    //////Try to move

    public boolean move(Coordinates battlefield, double gravity) {
        if(!mooving.isZero()) {
            Coordinates lastLocation = new Coordinates(location);
            location.add(mooving);
            if(bounded && outOfField(battlefield)) {
                location = lastLocation;
                return false;
            }
            return true;
        }
        return false;
    }
    public boolean changeMove (Coordinates battlefield, double gravity) {
        Coordinates newMooving = new Coordinates(mooving);
        newMooving.setY(mooving.getY()*-1.2);
        newMooving.setX(mooving.getX()*-1.8);
        location.add(newMooving);
        return true;
    }

    public boolean borderMoveX (Coordinates battlefield, double gravity) {
        Coordinates newMooving = new Coordinates(mooving);
        newMooving.addX(mooving.getX()-1);
        newMooving.setY(mooving.getY());
        location.add(newMooving);
        mooving.setX(mooving.getX()*-1);
        return true;
    }
    public boolean borderMoveY (Coordinates battlefield, double gravity) {
        Coordinates newMooving = new Coordinates(mooving);
        newMooving.addX(mooving.getX());
        newMooving.setY(mooving.getY()-1);
        location.add(newMooving);
        mooving.setY(mooving.getY()*-1);
        return true;
    }
    /////Displays
    public String displayAngle() {
        return String.valueOf(angle);
    }
    
    /////////////
    protected void setAs(objects other) {
        this.angle = other.getAngle();
        this.location = new Coordinates(other.location);
        this.mooving = new Coordinates(other.mooving);
        this.size = new Coordinates(other.size);
        this.bounded = other.bounded;
    }
    
    public boolean collides(objects object) {
        return location.distance(object.location) < (Math.min(size.getX(), size.getY()) + Math.min(object.size.getX(), object.size.getY())) / 2;
    }
    
    public boolean attention(objects object) {
        return location.distance(object.location) < (Math.min(size.getX(), size.getY()) + Math.min(object.size.getX(), object.size.getY())) *2;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visitObjects(this);
    }
}
