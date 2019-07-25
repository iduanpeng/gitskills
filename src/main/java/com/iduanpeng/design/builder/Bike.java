package com.iduanpeng.design.builder;

public  class Bike {
    private IFrame iFrame;

    private ISeat iSeat;

    public IFrame getiFrame() {
        return iFrame;
    }

    public void setiFrame(IFrame iFrame) {
        this.iFrame = iFrame;
    }

    public ISeat getiSeat() {
        return iSeat;
    }

    public void setiSeat(ISeat iSeat) {
        this.iSeat = iSeat;
    }
}
