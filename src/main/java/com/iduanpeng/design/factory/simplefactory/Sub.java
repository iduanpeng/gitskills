package com.iduanpeng.design.factory.simplefactory;

public class Sub implements Operation {

    public double getResult(double numberA, double numberB) throws Exception {
        return numberA - numberB;
    }
}
