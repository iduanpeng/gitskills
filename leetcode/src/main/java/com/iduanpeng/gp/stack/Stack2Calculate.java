package com.iduanpeng.gp.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基本计算器
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 */
public class Stack2Calculate {

    private int RIGHT_BRACKET = ')';

    public int calculate(String s){
        //针对特殊用例 -2 + 1
        s = s.trim();
        if (s.charAt(0) == '-'){
            s = "0" + s;
        }
        int len = s.length();
        char[] charArray = s.toCharArray();
        //只使用一个栈（保存操作数 和操作符）
        Deque<Integer> stack = new ArrayDeque<>();
        //累计的操作数
        int operand = 0;
        //累计的位数 转换123 从右向左 底数 1 10 100
        int n = 1;
        //从后往前
        for (int i = len - 1; i >= 0; i--){
            char ch = charArray[i];
            if (ch == ' '){
                continue;
            }
            if (Character.isDigit(ch)){
                //操作数累积起来
                int i1 = ch - '0';
                operand = n * i1 + operand;
                n *=10;
                continue;
            }
            if (n != 1){
                //将操作数保存到栈，并初始化 operand 和 n
                stack.addLast(operand);
                operand = 0;
                n = 1;
            }
            if (ch == '+'){
                stack.addLast(1);
                continue;
            }
            if (ch == '-'){
                stack.addLast(-1);
                continue;
            }
            if (ch == '('){
                int res = evaluateExpr(stack);
                stack.removeLast();
                stack.addLast(res);
            } else {
                stack.addLast(RIGHT_BRACKET);
            }
        }
        if (n != 1){
            stack.addLast(operand);
        }
        return evaluateExpr(stack);
    }
    public int evaluateExpr(Deque<Integer> stack){
        int res = 0;
        if (!stack.isEmpty()){
            res = stack.removeLast();
        }
        while (stack.size() > 1 && stack.peekLast() != RIGHT_BRACKET){
            res += stack.removeLast() * stack.removeLast();
        }
        return res;
    }

    public static void main(String[] args) {
       //String s = "(11+(4+5+2)-3)+(6+8)";
       String s = "11 + 2";
        Stack2Calculate c = new Stack2Calculate();
        int calculate = c.calculate(s);
        System.out.println(calculate);
    }


}
