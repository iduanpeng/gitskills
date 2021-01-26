package com.iduanpeng.gp.list;


public class List2 {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        List2 t = new List2();
        ListNode listNode = t.reverseList(list);
        System.out.println("普通循环实现结果：" + listNode);

        ListNode reverse = t.reverse(list2);
        System.out.println("递归实现结果：" + reverse);

    }


    /**
     * 翻转单链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            //置换pre 为 next 翻转
            cur.next = pre;
            // 重置 cur next
            pre = cur;
            cur = next;
        }
        //pre 遍历到最后一个元素时 全部翻转过来 返回
        return pre;
    }

    /**
     * 递归实现翻转整个链表
     * 当递归条件结束后 5.next = null 判断结束返回
     * 此时   head  last
     * 4      5   5->4>null
     * 3      4   5->4->3>null
     * 2      3   5->4->3->2->null
     * 1      2   5->4->3->2->1->null
     * return 5->4->3->2->1->null
     */
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 根据上述递归 扩展 翻转链表前N个节点
     */
    ListNode successor = null;// N 后驱节点

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            //记录第N + 1 个节点
            successor = head.next;
            return head;
        }
        //以head.next 为起点，需要翻转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 扩展翻转 中间 m - n 个位置的元素
     * 翻转中间范围内的节点 例如  1 - 2 - 3 - 4 -5
     * 定义    1<=m<=n<=长度        m       n
     * 翻转为  1 - 4 - 3 - 2 - 5
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        //base
        if (m == 1) {
            return reverseN(head, n);
        }
        //前进到反转的起点 触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 另外思路
     */





    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
