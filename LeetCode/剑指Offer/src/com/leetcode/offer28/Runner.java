package com.leetcode.offer28;


public class Runner {
    public static void main(String[] args) {
        /*CASE1
            1
           / \
          2   2
         / \ / \
        3  4 4  3
         */
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(3);
        n2.left = n5;
        n2.right = n6;

        Solution01 s1 = new Solution01();
        boolean result = s1.isSymmetric(root);
        System.out.println("result:" + result);


    }
}
