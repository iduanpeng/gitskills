package com.iduanpeng.base.generic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String resourceName= "1.2";
        int i = resourceName.indexOf(".");
        if (i > 0){
            String substring = resourceName.substring(i+1);
            System.out.println(substring);

        }
    }




}
