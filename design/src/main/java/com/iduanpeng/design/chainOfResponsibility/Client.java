package com.iduanpeng.design.chainOfResponsibility;

public class Client {
    public static void main(String[] args) {
        String input = "1";
        CaseChain caseChain = new CaseChain();
        caseChain.addBaseCase(new OneCase());
        //增加处理链
                //.addBaseCase(new TwoCase());
        caseChain.doSomething(input,caseChain);
    }
}
