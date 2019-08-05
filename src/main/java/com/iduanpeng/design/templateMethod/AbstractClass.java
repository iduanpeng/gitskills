package com.iduanpeng.design.templateMethod;

public abstract class AbstractClass {


    public void template(){
        before();//钩子 自类 可以自由扩展 不强制实现
        method1();//强制实现
        method2();
        method3();
        after();
    }

    public abstract void method1();

    public abstract void method2();

    public abstract void method3();

    public void before(){};

    public void after(){};

}
