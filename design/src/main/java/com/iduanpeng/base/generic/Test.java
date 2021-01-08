package com.iduanpeng.base.generic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String a = "a1b2c3";
        char[] test = test(a);
        for(int i = 0;i< test.length;i++){
            System.out.print(test[i]);
        }
    }

    public static char[] test(String s){
        char[] a = new char[s.length()];
        int numberIndex = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if (c >= '1' && c <= '9'){
                //添加 数字
                a[numberIndex] = c;
                numberIndex++;
            }
        }
        int charIndex = numberIndex;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
             if(c >= 'a' && c <= 'z'){
                //添加 字符
                a[charIndex]=c;
            }
        }
        return a;
    }


}
