package com.iduanpeng.design.chainOfResponsibility;

public interface BaseCase {
    void doSomething(String input, BaseCase baseCase);
}
