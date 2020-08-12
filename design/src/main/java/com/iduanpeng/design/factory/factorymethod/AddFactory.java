package com.iduanpeng.design.factory.factorymethod;

import com.iduanpeng.design.factory.simplefactory.Add;
import com.iduanpeng.design.factory.simplefactory.Operation;

public class AddFactory implements FactoryMethod {

    @Override
    public Operation createOperation() {
        return new Add();
    }

}
