package com.iduanpeng.design.observer;

public class Client {
    public static void main(String[] args) {
        Subject subject = new Wolf();
        Observer observer = new PleasantSheep();
        subject.attach(observer);
        //发送通知
        ((Wolf) subject).invade();

    }
}
