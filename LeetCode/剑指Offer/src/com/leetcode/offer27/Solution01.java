package com.leetcode.offer27;

import java.util.*;

/*
二叉树的镜像

题目：
请完成一个函数，输入一个二叉树，该函数输出它的镜像。
例如输入：
   4
  / \
 2   7
/ \  / \
1  3 6  9
镜像输出：
   4
  / \
 7   2
/ \  / \
9  6 3  1
 */
public class Solution01 {
    public TreeNode mirrorTree(TreeNode root) {
        // 使用递归的方法，思想描述是让根节点的左子树等于原来根节点的右子树，并且递归下去，这个根节点的右子树再作为根节点
        if (root != null) {
            TreeNode tempNode = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tempNode);
        }
        return root;
    }

    public void levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        if (root != null) {
            queue.add(root);
        }
        while (queue.size() != 0) {
            list.add(queue.peek().val);
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            queue.poll();
        }

        System.out.println(list);
    }
}
