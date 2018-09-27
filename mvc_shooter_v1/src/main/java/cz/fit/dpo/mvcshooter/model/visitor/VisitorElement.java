/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.visitor;

/**
 *
 * @author Анастасия
 */
public interface VisitorElement {
    public void accept(Visitor visitor);    
}
