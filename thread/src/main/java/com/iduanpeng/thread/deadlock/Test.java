package com.iduanpeng.thread.deadlock;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        long a = 11;
        long b = 11;

        BigDecimal divide = new BigDecimal(a).divide(new BigDecimal(b), 2, BigDecimal.ROUND_UP);
        BigDecimal multiply = divide.multiply(new BigDecimal("100"));
        int i = multiply.intValue();
        System.out.println(i);
        System.out.println(divide);
    }
}
