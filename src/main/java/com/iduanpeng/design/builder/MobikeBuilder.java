package com.iduanpeng.design.builder;


public class MobikeBuilder extends Builder {

    private Bike bike = new Bike();

    @Override
    Builder buildFame() {
        bike.setiFrame(new MobikeFrame());
        return this;
    }

    @Override
    Builder buildSeat() {
        bike.setiSeat(new MokieSeat());
        return this;
    }

    @Override
    Bike build() {
        return bike;
    }
}
