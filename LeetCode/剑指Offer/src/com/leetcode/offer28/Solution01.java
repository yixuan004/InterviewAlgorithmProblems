package com.leetcode.offer28;

/*
第一种递归的解法是十分需要学习的，树的很多操作都要采用递归的方法实现

实际上如果自己拿到这道题的话，应该也会用一些ArrayList的手段来做判断？

这个题明天需要复盘一下的感觉
 */
public class Solution01 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return recuseJudge(root.left, root.right);
        }
    }

    public boolean recuseJudge(TreeNode t1, TreeNode t2) {
        // 当前这个位置，遇到null有一些尾递归的结束条件
        if (t1 == null && t2 == null) {
            return true;
        } else if ((t1 != null && t2 == null) || (t1 == null && t2 != null)) {
            return false;
        } else { // t1 t2都不为null
            if (t1.val == t2.val) { // 在t1，t2都不是null的情况下，只有他们两个的val相等才继续递归判断
                if (recuseJudge(t1.left, t2.right) == true && recuseJudge(t1.right, t2.left) == true) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
