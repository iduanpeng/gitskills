package com.iduanpeng.javaBase;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,3);
        Integer integer = map.putIfAbsent(1, 1);
        System.out.println(integer);
        map.forEach((k,v) -> System.out.println(k + "-" + v));

    }
}
