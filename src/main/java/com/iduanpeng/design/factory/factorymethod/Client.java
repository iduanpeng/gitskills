package com.iduanpeng.design.factory.factorymethod;

import com.iduanpeng.design.factory.simplefactory.Operation;

public class Client {
    public static void main(String[] args) throws Exception {
        FactoryMethod addFactory = (FactoryMethod) Class
                .forName("com.iduanpeng.design.factory.factorymethod.AddFactory")
                .newInstance();
        Operation add = addFactory.createOperation();
        add.getResult(1,1);
    }
}
