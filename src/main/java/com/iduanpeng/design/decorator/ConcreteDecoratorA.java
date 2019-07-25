package com.iduanpeng.design.decorator;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        //相关业务代码
        super.sampleOperation();
        //相关业务代码
    }
}
