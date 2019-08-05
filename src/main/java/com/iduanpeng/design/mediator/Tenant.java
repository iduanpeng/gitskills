package com.iduanpeng.design.mediator;

public class Tenant extends Person {
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void constact(String message){
        mediator.constact(message,this);
    }

    public void getMessage(String message){
        System.out.println("租房者 ： "+ name + "获取" + message);
    }

}
