package com.iduanpeng.design.observer;

public class PleasantSheep implements Observer {

    @Override
    public void update() {
        System.out.println("喜羊羊收到通知");
    }
}
