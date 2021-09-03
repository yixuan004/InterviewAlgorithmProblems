package com.leetcode.offer25;

public class Solution01 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;

        // 注意最终要返回这个ListNode的next，如果是这样设置初始化的话
        ListNode resultHead = new ListNode(-1);
        ListNode result = resultHead;

        // 注意这里要用&&，否则会报空指针
        while(p != null && q != null) {
            // 两个选一个小的,加进头来
            ListNode tmp;
            if (p.val <= q.val) {
                tmp = new ListNode(p.val);
                p = p.next;
            } else {
                tmp = new ListNode(q.val);
                q = q.next;
            }
            result.next = tmp;
            result = result.next;
        }

        // 把一个不是null的不断拼接到结尾就可以了
        while (p != null) {
            ListNode tmp = new ListNode(p.val);
            result.next = tmp;
            result = result.next;
            p = p.next;
        }

        while (q != null) {
            ListNode tmp = new ListNode(q.val);
            result.next = tmp;
            result = result.next;
            q = q.next;
        }

        return resultHead.next;
    }
}
