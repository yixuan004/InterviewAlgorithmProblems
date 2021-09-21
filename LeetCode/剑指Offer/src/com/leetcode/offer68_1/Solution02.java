package com.leetcode.offer68_1;

public class Solution02 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                // 在二叉搜索树的条件下，找到第一个p在root左边，q在root右边（或者p=root， q=root这种情况），则退出
                return root;
            }
        }
        return root;
    }
}
