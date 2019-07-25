package com.iduanpeng.design.bridge;

/**
 * 对比最初的设计，将抽象部分（手机）与它的实现部分（手机软件类）分离，将实现部分抽象成单独的类，使它们都可以独立地变化
 *
 * 整个类图看起来像一座桥，所以称为桥接模式
 *
 * 继承是一种强耦合关系，子类的实现与它的父类有非常紧密的依赖关系，父类的任何变化 都会导致子类发生变化，因此继承或者说强耦合关系严重影响了类的灵活性，并最终限制了可复用性
 *
 * 从桥接模式的设计上我们可以看出聚合是一种比继承要弱的关联关系，手机类和软件类都可独立的进行变化，不会互相影响
 *
 */
public class Oppo extends Phone {
    @Override
    void run() {
        software.run();
    }
}
