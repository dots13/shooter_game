/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.coordinates;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Анастасия
 */
public class CoordinatesTest {
    
    public CoordinatesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of getX method, of class Coordinates.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Coordinates instance = new Coordinates(0.0,0.0);
        double expResult = 0.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getY method, of class Coordinates.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Coordinates instance = new Coordinates(0.0,0.0);
        double expResult = 0.0;
        double result = instance.getY();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setX method, of class Coordinates.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        double x = 5.0;
        Coordinates instance = new Coordinates(0.0,0.0);
        instance.setX(x);
        double result = instance.getX();
        assertEquals(5.0, result, 0.0);
    }

    /**
     * Test of setY method, of class Coordinates.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        double y = 5.0;
        Coordinates instance = new Coordinates(0.0,0.0);
        instance.setY(y);
        double result = instance.getY();
        assertEquals(5.0, result, 0.0);
    }

    /**
     * Test of addX method, of class Coordinates.
     */
    @Test
    public void testAddX() {
        System.out.println("addX");
        double i = 1.0;
        Coordinates instance = new Coordinates(0.0,0.0);
        instance.addX(i);
        double result = instance.getX();
        assertEquals(1.0, result, 0.0);
    }

    /**
     * Test of addY method, of class Coordinates.
     */
    @Test
    public void testAddY() {
        System.out.println("addY");
        double i = 1.0;
        Coordinates instance = new Coordinates(0.0,0.0);
        instance.addY(i);
        double result = instance.getY();
        assertEquals(1.0, result, 0.0);
    }

    /**
     * Test of distance method, of class Coordinates.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        Coordinates other = new Coordinates(0.0,0.0);
        Coordinates instance = new Coordinates(1.0,1.0);
        double expResult = Math.sqrt(1+1);
        double result = instance.distance(other);
        assertEquals(expResult, result, 0.0);
    }
    
}
