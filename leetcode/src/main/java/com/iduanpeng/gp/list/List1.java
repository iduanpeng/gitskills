package com.iduanpeng.gp.list;

import java.util.ArrayList;

public class List1 {

    /**
     * 数组 要求连续的内存空间
     * list 链表的实现 不需要连续的空间
     */

    /**
     * 约瑟夫环解决实现
     * 在罗马人占领乔塔帕特后，39 个犹太人与约瑟夫及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，
     * 41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止。然而约瑟夫
     * 和他的朋友并不想遵从，约瑟夫要他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏。
     */
    //总人数
    int m;
    //第几个人出局
    int n;
    ArrayList<String> circle = new ArrayList<>();

    //初始化
    public List1(int m, int n) {
        this.m = m;
        this.n = n;
        for (int i = 1; i <= m; i++) {
            circle.add(i + "");
        }
    }

    public void doAction() {
        ArrayList<String> temp = null;
        int k = n;
        while (true) {
            temp = (ArrayList<String>) circle.clone();
            if (temp.size() == 1) {
                System.out.println("最后一个出局的人：" + temp.get(0));
            }
            for (int i = 0; i < temp.size(); i++) {
                k--;
                if (k == 0) {
                    System.out.println("出局：" + temp.get(i));
                    circle.remove(temp.get(i));
                    k = n;//重新计数
                }
            }
        }
    }

    public static void main(String[] args) {
        List1 list1 = new List1(41,3);
        list1.doAction();
    }

}
