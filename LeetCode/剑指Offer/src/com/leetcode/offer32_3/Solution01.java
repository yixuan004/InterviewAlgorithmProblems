package com.leetcode.offer32_3;

import java.util.*;

public class Solution01 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        int count = 0;
        if (root != null) {
            queue.add(root);
            count ++;
        }
        while (queue.size() != 0) {
            List<Integer> tempList = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            int nowQueueSize = queue.size();
            count ++;
            if (count % 2 != 0) {
                for (int i = 0; i < nowQueueSize; i++) {
                    stack.push(queue.peek());
                    if (queue.peek().left != null) {
                        queue.add(queue.peek().left);
                    }
                    if (queue.peek().right != null) {
                        queue.add(queue.peek().right);
                    }
                    queue.poll();
                }
                while (stack.size() != 0) {
                    tempList.add(stack.pop().val);
                }
            } else {
                for (int i = 0; i < nowQueueSize; i++) {
                    tempList.add(queue.peek().val);
                    if (queue.peek().left != null) {
                        queue.add(queue.peek().left);
                    }
                    if (queue.peek().right != null) {
                        queue.add(queue.peek().right);
                    }
                    queue.poll();
                }
            }
            result.add(tempList);
        }

        // System.out.println("result: " + result);
        return result;
    }
}
