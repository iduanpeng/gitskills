package com.iduanpeng.design.observer;

public class Wolf extends Subject {
    public void invade(){
        System.out.println("灰太狼要搞事情了");
        notifyObserver();
    }
}
