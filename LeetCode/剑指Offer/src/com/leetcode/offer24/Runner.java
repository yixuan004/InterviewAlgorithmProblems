package com.leetcode.offer24;

public class Runner {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        ListNode d = new ListNode(4);
        c.next = d;

        Solution01 s1 = new Solution01();
        ListNode head = s1.reverseList(a);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
