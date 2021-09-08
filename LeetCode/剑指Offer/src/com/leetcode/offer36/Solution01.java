package com.leetcode.offer36;

import java.util.*;

public class Solution01 {
    Node head = new Node(-1);
    List<Node> tempList = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        interOrder(root); // 按照中序遍历的顺序加入了一个ArrayList中

        for (int i = 0; i < tempList.size(); i ++) {
            // System.out.println(tempList.get(i).val); // 这种list不能用角标，要用get

            // 往右走的序列
            if (i == tempList.size() - 1) {
                tempList.get(i).right = tempList.get(0);
            } else {
                tempList.get(i).right = tempList.get(i + 1);
            }

            // 往左走的序列
            if (i == 0) {
                tempList.get(i).left = tempList.get(tempList.size() - 1);
            } else {
                tempList.get(i).left = tempList.get(i - 1);
            }
        }

        head = tempList.get(0); // 指向最小的，放在这里

        return head;
    }

    public void interOrder(Node root) {
        if (root == null) {
            return ;
        }
        interOrder(root.left);
        // System.out.println(root.val);
        tempList.add(root);
        interOrder(root.right);
    }
}
