package com.iduanpeng.design.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void dettach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObserver(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
