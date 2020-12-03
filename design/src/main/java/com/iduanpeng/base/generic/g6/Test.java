package com.iduanpeng.base.generic.g6;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 不能创建确切类型的数组
        //List<String>[] lsa = new List<String>[10];
        //这样是可以的
        List<String>[] ls = new List[10];


    }
}
