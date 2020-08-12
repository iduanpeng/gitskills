package com.iduanpeng.design.adapter;

public class Adapter extends Adaptee implements Target {
    /**
     * 对象适配器可以直接实现target  增加Adaptee的属性对象
     */

    @Override
    public void request() {
        //一些操作
        super.adapteeRequest();
        //一些操作
    }
}
