/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.objects.missile.strategy;

import cz.fit.dpo.mvcshooter.model.coordinates.Coordinates;

/**
 *
 * @author Анастасия
 */
public interface MissileStrategy {
    public Coordinates getDirection(double gravity);
    
}
