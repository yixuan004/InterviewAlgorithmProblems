package com.leetcode.offer06;

/*
题目：
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例：
输入：head = [1,3,2]
输出：[2,3,1]

限制：
0 <= 链表长度 <= 10000
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution01 {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        int origStackSize = stack.size();
        int[] returnArray = new int[origStackSize];
        for (int i = 0; i < origStackSize; i++) { // 这里不能用stack.size()，因为随着pop会不断减小
            returnArray[i] = stack.pop();
            // System.out.println(returnArray[i]);
        }
        return returnArray;
    }
}
