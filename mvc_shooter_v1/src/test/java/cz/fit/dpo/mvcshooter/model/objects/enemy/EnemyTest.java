/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.objects.enemy;

import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Анастасия
 */
public class EnemyTest {
    
    public EnemyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getLivePoint method, of class Enemy.
     */
    @Test
    public void testGetLivePointSuper() {
        System.out.println("getLivePoint");
        Enemy instance = new SuperEnemy(new Coordinates(90,90));
        int expResult = 2;
        int result = instance.getLivePoint();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetLivePointRealistic() {
        System.out.println("getLivePoint");
        Enemy instance = new RealisticEnemy(new Coordinates(90,90));
        int expResult = 1;
        int result = instance.getLivePoint();
        assertEquals(expResult, result);
    }
    /**
     * Test of setLivePoint method, of class Enemy.
     */
    @Test
    public void testSetLivePoint() {
        System.out.println("setLivePoint");
        int i = 1;
        Enemy instance = new SuperEnemy(new Coordinates(90,90));
        instance.setLivePoint(i);
        int result = instance.getLivePoint();
        int expResult =1;
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocation method, of class Enemy.
     */
    @Test
    public void testSetLocation_Coordinates() {
        System.out.println("setLocation");
        Coordinates newLocation = new Coordinates(100,100);
        Enemy instance = new SuperEnemy(new Coordinates(220,220));
        instance.setLocation(newLocation);
        Coordinates expResult = new Coordinates(100, 100);
        Coordinates result = instance.getLocation();
        assertEqualsC(expResult,result);
    }
    private boolean assertEqualsC(Coordinates a, Coordinates b) {
        return (a.getX()== b.getX()) && (a.getY() == b.getY());
    }

    public class EnemyImpl extends Enemy {

        public Enemy clone() {
            return null;
        }
    }
    
}
