package com.iduanpeng.design.strategy;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        //使用哪个策略
        context.setStrategy(new ConcreteStrategyA());
        context.contextInterface();
    }
}
