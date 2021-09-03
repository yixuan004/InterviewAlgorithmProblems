package com.leetcode.offer18;

public class Solution01 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = head;
        // 单独处理头结点
        if (head == null) {
            return head;
        } else if (head.val == val) {
            return head.next;
        } else {
            while(p.next != null) {
                if (p.next.val == val) {
                    ListNode q = p;
                    if (p.next.next != null) {
                        q.next = p.next.next;
                    } else {
                        q.next = null;
                    }
                    break;
                }
                p = p.next;
            }
            return head;
        }
    }
}
