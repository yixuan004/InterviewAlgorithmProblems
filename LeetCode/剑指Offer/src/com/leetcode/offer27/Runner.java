package com.leetcode.offer27;

public class Runner {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(7);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);
        n2.left = n5;
        n2.right = n6;

//        Solution01 s1 = new Solution01();
//        s1.levelOrder(root);
//        TreeNode newRoot = s1.mirrorTree(root);
//        s1.levelOrder(newRoot);

        Solution02 s2 = new Solution02();
        s2.levelOrder(root);
        TreeNode newRoot2 = s2.mirrorTree(root);
        s2.levelOrder(newRoot2);
    }
}
