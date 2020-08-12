package com.iduanpeng.design.state;

public class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void doAction(String param){
        state.handle(param);
    }

}
