package com.iduanpeng.design.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class CaseChain implements BaseCase {

    private List<BaseCase> baseCases = new ArrayList<>();

    private int index = 0;

    public CaseChain addBaseCase(BaseCase baseCase){
        baseCases.add(baseCase);
        return this;
    }

    @Override
    public void doSomething(String input, BaseCase baseCase) {
        if (index == baseCases.size()){
            return;
        }
        BaseCase baseCase1 = baseCases.get(index);
        index++;
        baseCase1.doSomething(input,this);

    }
}
