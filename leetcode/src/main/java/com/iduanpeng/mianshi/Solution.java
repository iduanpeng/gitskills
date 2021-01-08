package com.iduanpeng.mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    List<Integer> list = new ArrayList<>();

    /**
     * 中序遍历
     * @param root
     */
    public void inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(stack!= null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.getVal());
            root = root.right;
        }
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }
    }
}
