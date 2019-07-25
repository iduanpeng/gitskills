package com.iduanpeng.design.bridge;

public abstract class Phone {
    protected Software software;

    abstract void run();

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }
}
