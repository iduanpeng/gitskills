package com.iduanpeng.design.builder;

/** 优点：
 * 1、产品的建造和表示分离，实现了解耦。
 *
 * 2、将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰
 *
 * 3、增加新的具体建造者无需修改原有类库的代码，易于拓展，符合“开闭原则“。
 * 缺点：
 * 1、产品必须有共同点，限制了使用范围。
 *
 * 2、如内部变化复杂，会有很多的建造类，难以维护。
 *
 *
 *
 *  与抽象工厂模式相比，建造者模式返回一个组装好的完整产品，
 *  而抽象工厂模式返回一系列相关的产品，这些产品位于不同的产品等级结构，构成了一个产品族 。
 *  在抽象工厂模式中，客户端实例化工厂类，然后调用工厂方法获取所需产品对象，
 *  而在建造者模式中，客户端可以不直接调用建造者的相关方法，而是通过指挥者类来指导如何生成对象，
 *  包括对象的组装过程和建造步骤，它侧重于一步步构造一个复杂对象，返回一个完整的对象 。
 *  如果将抽象工厂模式看成汽车配件生产工厂，生产一个产品族的产品，那么建造者模式就是一个汽车组装工厂，通过对部件的组装可以返回一辆完整的汽车
 *
 */
public class Client {
    public static void main(String[] args) {
        MobikeBuilder mobikeBuilder = new MobikeBuilder();
        Bike bike = mobikeBuilder.buildFame().buildSeat().build();
        System.out.print(bike);
        //增加指挥者 角色 组装的顺序可以封装调整
        Director director = new Director(mobikeBuilder);
        director.construct();
    }
}
