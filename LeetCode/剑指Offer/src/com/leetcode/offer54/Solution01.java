package com.leetcode.offer54;

public class Solution01 {
    int result;
    int count = 0;
    public int kthLargest(TreeNode root, int k) {
        result = root.val;
        interOrder(root, k);
        return result;
    }

    // 二叉搜索树的中序遍历就是按照顺序的，先左就是从小到大，先右就是从大到小
    public void interOrder(TreeNode root, int k) {
        if (root == null) {
            return ;
        }
        interOrder(root.right, k);
        count ++;
        if (count == k) {
            result = root.val;
            return ;
        }
        // System.out.println(root.val); // 中序遍历
        interOrder(root.left, k);
    }
}
