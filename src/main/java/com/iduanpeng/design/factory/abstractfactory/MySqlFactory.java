package com.iduanpeng.design.factory.abstractfactory;

public class MySqlFactory implements SqlFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }
}
