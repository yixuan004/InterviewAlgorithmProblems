package com.leetcode.offer26;

/*
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
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
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 */
public class Solution01 {
    /*
    一种双重循环的思想，首先需要遍历子树A的所有节点
    之后，在子树A的所有节点上，判断以这个节点作为根的子树是否和B相等

    树的很多操作需要判断是否为null，这个需要特别注意下
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null){
            return false; // (约定空树不是任意一个树的子结构)
        } else { // B != null
            if (A == null) {
                return false;
            } else { // A != null
                // 走判断逻辑，如果当前的可以，或者A的左子节点可以，或者A的右子节点可以
                // 这个return逻辑要做一个学习，就是说当前这几个递归条件，内部任意有一组满足了，就可以了
                return judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
            }
        }
    }

    public boolean judge(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        // 因为判定B是不是A的子结构，这里假设对于一个根节点，仍有右子树，而B不具有这部分右子树，那么也认为B是A的一个结构
        else if (A != null && B == null) {
            return true;
        } else if (A == null && B != null) {
            return false;
        } else {
            if (A.val == B.val) {
                // 这种组合条件的return要写熟悉了才行啊
                return judge(A.left, B.left) && judge(A.right, B.right); // 如果往下递归，都满足，才会true
            } else {
                return false;
            }
        }
    }
}
