package com.leetcode.offer26;

public class Runner {
    public static void main(String[] args) {

        /*
        给定的树 A:
          3
          / \
         4  5
         / \
        1  2

        给定的树 B：
         4
         /
        1
         */

        TreeNode rootA = new TreeNode(3);
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(5);
        rootA.left = a1;
        rootA.right = a2;
        TreeNode a3 = new TreeNode(1);
        TreeNode a4 = new TreeNode(2);
        a1.left = a3;
        a1.right = a4;

        TreeNode rootB = new TreeNode(4);
        TreeNode b1 = new TreeNode(1);
        rootB.left = b1;

        Solution01 s1 = new Solution01();
        boolean result = s1.isSubStructure(rootA, rootB);
        System.out.println("result: " + result);
    }
}
