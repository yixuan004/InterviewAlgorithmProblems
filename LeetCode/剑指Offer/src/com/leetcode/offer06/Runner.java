package com.leetcode.offer06;

public class Runner {
    public static void main(String[] args) {
        // System.out.println("hello，world");

        // 构造测试用例使用
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        // System.out.println("a.next.next.val: " + a.next.next.val);


        Solution01 s1 = new Solution01();
        s1.reversePrint(a);
    }
}
