package com.leetcode.offer35;

import java.util.Map;
import java.util.HashMap;

/*
题目：
    请实现 copyRandomList 函数，复制一个复杂链表。
    在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

提示：
    -10000 <= Node.val <= 10000
    Node.random 为空（null）或指向链表中的节点。
    节点数目不超过 1000 。

Reference：
    https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/
 */
public class Solution01 {
    public Node copyRandomList(Node head) {

        // 异常处理
        if (head == null) {
            return null;
        }

        // 主要用来做原来链表的一个复制的对应使用
        Map<Node, Node> hmap = new HashMap<>();

        // 复制一遍原来的链表，但是只是把每个单独的节点复制出来存在hmap里，为了后边索引来使用
        // 也就是说，这里的思路是先完全把每个节点单独起来，创造老节点-新节点的mapping，然后再使用老链表把新链表连在一起
        Node p = head;
        while (p != null) {
            hmap.put(p, new Node(p.val)); // 根据老的，建立一个新的
            p = p.next;
        }

        // 根据老的链表，把新链表按照老链表的规则拼接在一起
        p = head;
        while (p != null) {
            hmap.get(p).next = hmap.get(p.next); // 这个是本来复制就能做的
            hmap.get(p).random = hmap.get(p.random); // 注意这里next和random都是在里边的
            p = p.next;
        }

        return hmap.get(head); // 会返回新链表的头

        /*
        最后再来分析下如果直接复制存在的问题，主要的原因就是在复制的过程中，随机指向的那个可能还没有创建

        如果在遍历过程中随用随建的话，又有可能创建出来两个新的，所以要用mapping保证永远是那一个

        所以要先完全把链表的节点全创建出来，再用HashMap简单的mapping一下
         */
    }
}
