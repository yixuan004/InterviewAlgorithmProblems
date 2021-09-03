package com.leetcode.offer52;

import java.util.*;

public class Solution01 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 暂时刷题还是希望能找到一些通用的做法
        Set<ListNode> listNodeSet = new HashSet<>(); // set本质上就是一个boolean的dict

        // 遍历链表A，把A的所有节点都加入到set中
        ListNode p = headA;
        while (p != null) {
            boolean addResult = listNodeSet.add(p); // 会有一个返回值
            // System.out.println("addResult: " + addResult);
            // boolean removeResult = listNodeSet.remove(p); // 主要就是add和remove方法
            // System.out.println("removeResult: " + removeResult);
            p = p.next;
        }

        // 开始遍历链表B，判断B的每个节点是否在A中，如果在的话，就把那个节点返回就可以了
        ListNode q = headB;
        while (q != null) {
            boolean addResult = listNodeSet.add(q);
            if (addResult == false) {
                return q;
            }
            q = q.next;
        }
        return null; // 如果两个链表没有交点的话，就返回null
    }
}
