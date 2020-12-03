package com.iduanpeng.base.generic.g1;

import java.util.ArrayList;
import java.util.List;

/** 泛型类
 * 通常情况下 T E K V ? 是这样约定的
 * ？ 表示不确定的java类型
 * T （type） 表示具体的一个java类型
 * K V 分表java键值中的 key value
 * E 代表element
 *
 * @param <T>
 */
public class GenericTest<T> {

    public  T getObject(Class<T> t) throws Exception{
        T c = t.newInstance();
        return c;
    }

    //？ T 区别
    //指定集合元素只能是T类型
    List<T> list = new ArrayList<>();
    //T t = new operate();
    //集合元素可以是任意类型，这种声明没有意义
    List<?> list1 = new ArrayList<>();
    //? car = new operate() 不可以
    /**
     * T 是一个 确定的 类型，通常用于泛型类和泛型方法的定义，
     * ？是一个 不确定 的类型，通常用于泛型方法的调用代码和形参，不能用于定义类和泛型方法。
     */


    //Class<T> 和 Class<?> 的区别




}
