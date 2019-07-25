package com.iduanpeng.design.proxy.staticproxy;

public class BuyHoseProxy implements BuyHose{
    private BuyHose buyHose;

    public BuyHoseProxy(BuyHose buyHose) {
        this.buyHose = buyHose;
    }

    @Override
    public void buyHose() {
        System.out.print("买房前准备");
        buyHose.buyHose();
        System.out.print("买房后准备");
    }
}
