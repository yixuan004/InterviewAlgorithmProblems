package com.leetcode.offer22;

public class Solution01 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        int count = 0;

        while (p != null) {
            if (count == k) {
                p = p.next;
                q = q.next;
            } else {
                count ++;
                p = p.next;
            }
        }
        return q;
    }
}