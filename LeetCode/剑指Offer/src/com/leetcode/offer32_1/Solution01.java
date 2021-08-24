package com.leetcode.offer32_1;

import java.util.*;

public class Solution01 {
    public int[] levelOrder(TreeNode root) {
        // 层序遍历，使用Queue
        Deque<TreeNode> q = new LinkedList<>(); // LinkedList模拟栈，也可以用来模拟queue的
        ArrayList<Integer> arrList = new ArrayList<>(); // 最后用来向数组传递值返回

        if (root != null){
            q.push(root);
        }
        while(q.size() != 0) {
            System.out.println("peek是队的哪里：" + q.peek().val);
            arrList.add(q.peek().val); // peek是队列的队头，是栈的顶
            if (q.peek().left != null) {
                q.add(q.peek().left); // 队列要使用add方法，栈要使用push方法
            }
            if (q.peek().right != null) { // 队列要使用add方法，栈要使用push方法
                q.add(q.peek().right);
            }
            q.poll(); // 删除队头是poll()，删除队尾是pop()
        }

        // System.out.println(arrList);
        int[] returnArray = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            returnArray[i] = arrList.get(i);
        }
        return returnArray;
    }
}
