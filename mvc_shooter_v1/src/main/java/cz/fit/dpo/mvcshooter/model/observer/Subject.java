/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fit.dpo.mvcshooter.model.observer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Анастасия
 */
public abstract class Subject {
    private Set<Observer> observers;

    public Subject() {
        observers = new HashSet<Observer>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.observerNotify();
        }
    }
}

