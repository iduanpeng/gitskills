package com.iduanpeng.design.flyweight;

/**
 * 抽象享元类
 */
public interface ChessFlyWeight {
    void setColor(String c);

    String getColor();

    void display(Coordinate c);
}
