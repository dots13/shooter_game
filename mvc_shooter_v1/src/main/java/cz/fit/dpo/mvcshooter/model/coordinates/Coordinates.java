/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.coordinates;

/**
 *
 * @author Анастасия
 */
public class Coordinates {
    private double x;
    private double y;

    public Coordinates(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates coordinates)	{
        x = coordinates.getX();
        y = coordinates.getY();
    }

    public Coordinates add(Coordinates other) {
        this.addX(other.getX());
        this.addY(other.getY());
        return this;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public void addX(double i) {
        this.x += i;
    }
    
    public void addY(double i) {
        this.y += i;
    }
    
    public boolean isZero() {
        return this.getX() + this.getY() == 0;
    }
    public double distance(Coordinates other) {
        double a = getX() - other.getX();
        double b = getY() - other.getY();
        return Math.sqrt(a*a + b*b);
    }
    public void diminish(double divisor) {
        if (Math.abs(x) <= 1) {
            x = 0;
        }
        if (Math.abs(y) <= 1) {
            y = 0;
        }
        x /= divisor;
        y /= divisor;
    }
}
