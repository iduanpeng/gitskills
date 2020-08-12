package com.iduanpeng.design.facade;

public class Car {
    private Engine engine;

    private Tyre tyre;

    public Car(Engine engine, Tyre tyre) {
        this.engine = engine;
        this.tyre = tyre;
    }

    public void drive(){
        engine.startUp();
        tyre.roll();
    }

    public static void main(String[] args) {
        Car car = new Car(new Benz(),new Giti());
        car.drive();
    }
}
