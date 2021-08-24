package com.leetcode.offer32_2;

import java.util.*;

/*
题目：
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

示例：
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]

提示：
节点总数 <= 1000
 */
public class Solution01 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (queue.size() != 0) {
            // 准备做该层的pop操作
            int nowQueueSize = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < nowQueueSize; i++) { // 每次只加入当前层的节点数目次，这里多加一个控制条件的感觉
                tempList.add(queue.peek().val);
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                queue.poll();
            }
            result.add(tempList);
        }

        System.out.println("result: " + result);

        return result;
    }
}
