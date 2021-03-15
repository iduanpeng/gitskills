package com.iduanpeng.design.singleton;

import java.util.Date;

/**
 *
 * instance=new singleton();这条语句并不是一个原子操作
 * 1.分配内存给对象，在内存中开辟一段地址空间；// singleton var = new singleton();
 * 2.对象的初始化；// var = init();
 * 3.将分配好对象的地址指向instance变量，即instance变量的写；// instance = var;
 * 设想一下，如果不使用volatile关键字限制指令的重排序，1-3-2操作，
 * 获得到单例的线程可能拿到了一个空对象，后续操作会有影响！因此需要引入volatile对变量进行修饰。
 *
 * volatile 没有实验出来
 *
 * 网上有人说，这种实现方式有些问题。因为指令重排序，可能会导致 IdGenerator 对象被 new 出来，并且赋值给 instance 之后，
 * 还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了。要解决这个问题，我们需要给 instance 成员变量加上 volatile 关键字，
 * 禁止指令重排序才行。实际上，只有很低版本的 Java 才会有这个问题。
 * 我们现在用的高版本的 Java 已经在 JDK 内部实现中解决了这个问题（解决的方法很简单，只要把对象 new 操作和初始化操作设计为原子操作，就自然能禁止重排序）
 */
public class LazySingleton {
    private static /*volatile*/ LazySingleton instance = null;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (instance == null) {
            synchronized (LazySingleton.class){
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0;i < 1000 ;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LazySingleton instance = LazySingleton.getInstance();
                    System.out.println(instance);
                }
            }).start();
        }
    }

    /**
     * 静态内部类实现方式
     * SingletonHolder 是一个静态内部类，当外部类 被加载的时候，并不会创建 SingletonHolder 实例对象.
     * 只有当调用 getInstance() 方法时，SingletonHolder 才会被加载，这个时候才会创建 instance。
     * instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。所以，这种实现方法既保证了线程安全，又能做到延迟加载
     */
    private static class SingletonHolder{
        private static final LazySingleton instance = new LazySingleton();
    }

    public static LazySingleton getInstance2(){
        return SingletonHolder.instance;
    }

}
