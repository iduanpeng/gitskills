package com.iduanpeng.base.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    public static void main(String[] args) {
        //map put过程解析
        HashMap<Object,Integer> map = new HashMap<>(16);
        for (int i = 0;i < 17;i++){
            map.put(i,i);
        }
        map.put(1,1);
        Node node = new MapTest().new Node();
        map.put(node,1);
        Integer integer = map.get(node);
        System.out.println(integer);

    }

    public class Node{
        private String s;

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

}
