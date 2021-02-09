package com.iduanpeng.gp.list;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * linkedHashMap 实现
 */
public class LRUCache1 {

    int capacity;

    Map<Integer,Integer> map;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        //先删除旧位置，再放入新位置
        Integer value = map.remove(key);
        map.put(key,value);
        return value;
    }

    public void put(int key,int value){
        if (map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        map.put(key,value);
        //超过size 删除第一个
        if (map.size() > capacity){
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }


}
