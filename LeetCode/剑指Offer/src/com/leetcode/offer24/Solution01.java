package com.leetcode.offer24;

/*
题目：
    定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
示例：
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
限制：
    0 <= 节点个数 <= 5000

 */
public class Solution01 {
    public ListNode reverseList(ListNode head) {
        ListNode p = head; // 指向原有链表的头结点，用于遍历原来的原有链表
        ListNode qHead = null;
        while (p != null) {
            // 主要是进行一个头插法，注意，不是在原来的链表上修改
            if (qHead == null) {
                qHead = new ListNode(p.val);
            } else {
                ListNode tempHead = new ListNode(p.val); // 定义一个新的
                tempHead.next = qHead;
                qHead = tempHead;
            }
            // System.out.println(p.val);
            p = p.next;
        }
        return qHead;
    }
}
