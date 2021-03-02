package com.iduanpeng.gp.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 * 对于栈来说，如果一个元素 a 在入栈时，栈里有其它的元素 b, c, d，那么无论这个栈在之后经历了什么操作，只要 a 在栈中，b, c, d 就一定在栈中，因为在 a 被弹出之前，b, c, d 不会被弹出。
 *
 * 因此，在操作过程中的任意一个时刻，只要栈顶的元素是 a，那么我们就可以确定栈里面现在的元素一定是 a, b, c, d。
 *
 * 那么，我们可以在每个元素 a 入栈时把当前栈的最小值 m 存储起来。在这之后无论何时，如果栈顶元素是 a，我们就可以直接返回存储的最小值 m。
 *
 */
public class Stack3MinStack {

    Deque<Integer> xStack;

    Deque<Integer> minStack;

    public Stack3MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x){
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop(){
        xStack.pop();
        minStack.pop();
    }

    public int top(){
        return xStack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

}
