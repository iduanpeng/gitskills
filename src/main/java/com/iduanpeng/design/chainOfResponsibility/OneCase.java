package com.iduanpeng.design.chainOfResponsibility;

public class OneCase implements BaseCase {
    @Override
    public void doSomething(String input, BaseCase baseCase) {
        if (input.equals("1")){
            System.out.println("处理中。。。");
            return;
        }
        //当前的没法处理，找下一个处理
        baseCase.doSomething(input,baseCase);
    }
}
