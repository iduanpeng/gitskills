package com.iduanpeng.gp.stack;

import java.util.Stack;

public class Stack1 {

    /**
     * 括号验证 （） true (} false (){} true (> false
     */

    public static void main(String[] args) {
        System.out.println(isValid("()()"));
    }

    public static boolean isValid(String s){
        if (s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (Character character : stack) {
            if (character == '(' || character == '{' || character == '['){
                stack.push(character);
            }
            if (character == ')'){
                if (stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            //其他括号类型 同理

        }
        return stack.isEmpty();
    }

}
