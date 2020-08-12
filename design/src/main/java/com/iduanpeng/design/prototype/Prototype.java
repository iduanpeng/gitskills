package com.iduanpeng.design.prototype;

public class Prototype implements Cloneable {

    /**
     * 根据业务需要可能会重写clone方法达到深克隆的目的
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
