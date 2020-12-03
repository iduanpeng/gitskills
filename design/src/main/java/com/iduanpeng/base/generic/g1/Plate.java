package com.iduanpeng.base.generic.g1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <T>
 */
public class Plate<T extends Fruit> {

    private T item;
    public Plate(T t){
        this.item = t;
    }
    public void set(T t){
        this.item = t;
    }
    public T get(){
        return item;
    }

    public static void main(String[] args) {
        //Plate<Fruit> p = new Plate<Apple>(new Apple());
        //会报错 我们不可以把Plate<Apple>的引用传递给Plate<Fruit>。
        //为了让泛型用起来更舒服，Sun的大师们就想出了<? extends T>和<? super T>的办法，来让”水果盘子“和”苹果盘子“之间发生正当关系。
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());

        //entends 和super 通配符副作用
        //上界<? extends T>不能往里存，只能往外取
        //p.set(new Fruit()); error
        //p.set(new Apple()); error
        // 读取出来的东西只能放在fruit 或fruit的基类
        Fruit fruit = p.get();
        //Apple a = p.get(); error
        // 原因：编译器只知道容器内是Fruit或者它的派生类，但具体是什么类型不知道。

        /**
         * 可能是Fruit？可能是Apple？也可能是Banana，RedApple，GreenApple？
         * 编译器在看到后面用Plate<Apple>赋值以后，盘子里没有被标上有“苹果”。而是标上一个占位符：capture#1，
         * 来表示捕获一个Fruit或Fruit的子类，具体是什么类不知道，代号capture#1。
         *
         * 然后无论是想往里插入Apple或者Meat或者Fruit编译器都不知道能不能和这个capture#1匹配，所以就都不允许。
         */

        //下界<? super T>不影响往里存，但往外取只能放在Object对象里
        Plate<? super Fruit> p1 = new Plate<>(new Apple());
        p1.set(new Fruit());
        p1.set(new Apple());

        //读取出来的只能放在object里
        Object object = p1.get();

        //PECS（Producer Extends Consumer Super）原则

        List<? extends Fruit> s = new ArrayList<>();
        //s.add(new Apple());
        //s.add("1");
        List<? super Fruit> s1 = new ArrayList<>();
        s1.add(new Fruit());
        s1.add(new Apple());
        System.out.println(s1);

        Plate p2 = new Plate(new Apple());
        p2.set(new Apple());

        Plate<? extends Fruit> p3 = new Plate<>(new Apple());
        //p3.set(new Apple()); error
    }
}
