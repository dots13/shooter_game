/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.memento;

/**
 *
 * @author Анастасия
 */
public class Memento {
    private Originator originator;
    
    
    public Memento(Originator originator) {
        this.originator = originator;
    }
    
    
    public Originator getOriginator() {
        return originator;
    }
    
    
    public void setOriginator(Originator originator) {
        this.originator = originator;
    }    
}
