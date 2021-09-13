package com.leetcode.offer55_1;

public class Solution01 {
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1; // 两边最大深度
    }
}
