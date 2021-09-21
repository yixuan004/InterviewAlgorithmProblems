package com.leetcode.offer68_1;

/*
题目：
    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：
    “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

个人分析：
    这道题由于给了二叉搜索树的条件需要进行合理应用

    如果root是p q的最近公共祖先，有以下几种情况
    1）root是根，并且p q分别在root的左子树和右子树中
    2）root = p；q在root的左子树或者右子树中
    3）root = q；p在root的左子树或者右子树中

    这个题使用递归的方法还是比较好理解，由于二叉搜索树的性质，如果当不满足以上三种情况时
    只能是还没有找到公共祖先，也就是两个还处在一边的状态，所以要从左边作为新的根，从右边作为新的根开始递归
 */
public class Solution01 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
