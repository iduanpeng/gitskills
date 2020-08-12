package com.iduanpeng.design.factory.factorymethod;

import com.iduanpeng.design.factory.simplefactory.Operation;
import com.iduanpeng.design.factory.simplefactory.Sub;

public class SubFactory implements FactoryMethod {
    @Override
    public Operation createOperation() {
        return new Sub();
    }
}
