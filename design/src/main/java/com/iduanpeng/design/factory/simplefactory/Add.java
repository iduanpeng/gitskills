package com.iduanpeng.design.factory.simplefactory;

public class Add implements Operation {

    public double getResult(double numberA, double numberB) throws Exception {
        return numberA + numberB;
    }
}
