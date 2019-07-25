package com.iduanpeng.design.builder;

public class Director {
    private Builder builder;

    Director(Builder builder){
        this.builder = builder;
    }

    public Bike construct(){
        return builder.buildFame().buildSeat().build();
    }

}
