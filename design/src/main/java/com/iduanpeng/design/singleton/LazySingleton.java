package com.iduanpeng.design.singleton;

/**
 *
 * instance=new singleton();这条语句并不是一个原子操作
 * 1.分配内存给对象，在内存中开辟一段地址空间；// singleton var = new singleton();
 * 2.对象的初始化；// var = init();
 * 3.将分配好对象的地址指向instance变量，即instance变量的写；// instance = var;
 * 设想一下，如果不使用volatile关键字限制指令的重排序，1-3-2操作，
 * 获得到单例的线程可能拿到了一个空对象，后续操作会有影响！因此需要引入volatile对变量进行修饰。
 */
public class LazySingleton {
    private static volatile LazySingleton instance = null;

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
}
