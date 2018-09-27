/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.objects.cannon.state;

import cz.fit.dpo.mvcshooter.model.objects.cannon.Cannon;
import cz.fit.dpo.mvcshooter.model.objects.missile.Missile;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Анастасия
 */
public class DoubleState implements CannonState{
    
    @Override
    public List<Missile> fire(Cannon cannon, int power) {
        double range = 0.3f;
        return Arrays.asList(
                cannon.getObjFactory().createMissile(cannon.getLocation(), cannon.getAngle() + range/2, power),
                cannon.getObjFactory().createMissile(cannon.getLocation(), cannon.getAngle() - range/2, power)
        );      
    }
    
}
