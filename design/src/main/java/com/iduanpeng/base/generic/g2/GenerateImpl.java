package com.iduanpeng.base.generic.g2;

/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * class GenerateImpl implements Generate<T>，编译器会报错
 * @param <T>
 */
public class GenerateImpl<T> implements Generate<T> {
}
