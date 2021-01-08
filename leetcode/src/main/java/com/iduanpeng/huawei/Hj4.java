package com.iduanpeng.huawei;

import java.util.Scanner;

/**
 * 进制转换
 */
public class Hj4 {
    //写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
    //0xA
    //0xAA

    //10
    //170
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            Integer integer = Integer.valueOf(s.substring(2), 16);
            System.out.println(integer);
        }
    }
}
