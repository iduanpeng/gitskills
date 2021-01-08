package com.iduanpeng.huawei;

import java.util.Scanner;

/**
 * 字符串最后一个单词的长度
 */
public class Hj1 {

    // 输入描述 输入一行代表要计算的字符串，非空 长度小于5000
    // 输出描述 输出一个整数，表示输入字符串最后一个单词的长度
    // hello nowcoder
    // 8

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        String s2 = s1[s1.length - 1];
        System.out.println(s2.length());
    }

}
