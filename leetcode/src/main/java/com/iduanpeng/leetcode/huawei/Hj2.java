package com.iduanpeng.leetcode.huawei;

import java.util.Scanner;

/**
 * 计算字符个数
 */
public class Hj2 {
    // 输入 由字母和数字以及空格组成的字符串，第二行输入一个字母
    // 输出 sshu输入字符串中含有该字符的个数 不区分大小写
    // ABCabc
    // A
    // 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();
        String s1 = scanner.nextLine();
        System.out.println(s.length() - s.replace(s1,"").length());
    }
}
