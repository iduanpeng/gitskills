package com.iduanpeng.design.state;

public class ConcreteStateA implements State {

    @Override
    public void handle(String param) {
        System.out.println("concrete handle...");
    }
}
