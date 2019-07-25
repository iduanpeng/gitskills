package com.iduanpeng.design.factory.abstractfactory;

public class Client {
    public static void main(String[] args) {
        SqlFactory factory = new MySqlFactory();
        IUser user = factory.createUser();
        user.getUser(1);
        user.insert(new User());
    }
}
