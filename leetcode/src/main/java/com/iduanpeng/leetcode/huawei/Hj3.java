package com.iduanpeng.leetcode.huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 明明的随机数
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
 * 他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，
 * 把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 * 按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作
 * (同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 */
public class Hj3 {
    /**
     * 输入可能有多组数据。每组数据都包括多行，第一行先输入随机整数的个数N，
     * 接下来的N行再输入相应个数的整数。具体格式请看下面的"示例"。
     * 返回多行，处理后的结果
     * 3                 1
     * 2                2
     * 2                 10
     * 1                15
     * 11                20
     * 10               32
     * 20               40
     * 40               67
     * 32               89
     * 67               300
     * 40               400
     * 20
     * 89
     * 300
     * 400
     * 15
     * 样例输入解释：
     * 样例有两组测试
     * 第一组是3个数字，分别是：2，2，1。
     * 第二组是11个数字，分别是：10，20，40，32，67，40，20，89，300，400，15。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            TreeSet<Integer> set = new TreeSet();
            for (int j = 0 ; j< i ;j++){
                set.add(scanner.nextInt());
            }
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}
