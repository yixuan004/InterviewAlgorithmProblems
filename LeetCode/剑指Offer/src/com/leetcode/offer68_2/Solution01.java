package com.leetcode.offer68_2;

public class Solution01 {
    // 整体思路：使用前序遍历框架，每次分别在根节点的左边和右边找p，q，如果能找到则会返回p，q，如果找不到则会返回null
    // 这种情况下会返回四种情况：left right 分别有值和为null的情况
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q); // 目标就是在找公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 目标就是在找公共祖先

        // 分四种情况进行讨论：
        if (left == null && right == null) {
            return null; // 左右都没有找到，返回null
        } else if (left != null && right != null) {
            return root; // 左右都找到了，那么这个地方的root就是最近的根了
        } else if (left != null && right == null) {
            // 左边不为空，右边为空，也就是说这个点一定已经是p或者q了，并且
            return left;
        } else {
            // 左边为空，右边不为空，即pq都在这个root的右边
            return right;
        }
    }
}
