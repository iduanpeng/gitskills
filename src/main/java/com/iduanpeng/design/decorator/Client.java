package com.iduanpeng.design.decorator;

public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecoratorA(component);
        decorator.sampleOperation();
        //不同的类增加其功能特性
        Decorator decorator1 = new ConcreteDecoratorA(new ConcreteDecoratorA(component));

    }
}
