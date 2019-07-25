package com.iduanpeng.design.proxy.dynamicproxy;

import com.iduanpeng.design.proxy.staticproxy.BuyHose;
import com.iduanpeng.design.proxy.staticproxy.BuyHoseImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler {

    private Object targetObject ;

    public Object newProxyInstance(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始前");
        Object result = method.invoke(targetObject,args);
        return result;
    }

    public static void main(String[] args) {
        BuyHose buyHose = new BuyHoseImpl();
        DynamicProxyHandler handler = new DynamicProxyHandler();
        BuyHose o = (BuyHose)handler.newProxyInstance(buyHose);
        o.buyHose();
    }
}
