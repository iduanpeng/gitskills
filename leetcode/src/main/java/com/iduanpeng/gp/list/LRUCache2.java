package com.iduanpeng.gp.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用双链表加hashmap
 */
public class LRUCache2 {
    private int capacity;

    private Map<Integer,ListNode> map;

    private ListNode head;

    private ListNode tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        //先从链表中删除，再添加到末尾
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveToTail(node);
        return node.val;
    }

    public void put (int key,int value){
        // 直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
        if (get(key) != -1){
            map.get(key).val = value;
            return ;
        }
        //若不存在 new 一个出来，如果超出容量，把头去掉
        ListNode node = new ListNode(key,value);
        map.put(key,node);
        moveToTail(node);
        if (map.size() > capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    /**
     * 把节点移动到末尾
     * @param node
     */
    private void moveToTail(ListNode node){
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }



    private class ListNode{
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
}
