package com.iduanpeng.design.factory.abstractfactory;

public class OracleFactory implements SqlFactory {
    @Override
    public IUser createUser() {
        return new OracleUser();
    }
}
