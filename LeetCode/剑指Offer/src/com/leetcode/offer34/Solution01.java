package com.leetcode.offer34;

import java.util.*;

public class Solution01 {
    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> tempList = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        preOrderDfs(root, target);
        return result;
    }

    public void preOrderDfs(TreeNode root, int target) {
        if (root == null) {
            return ;
        }
        tempList.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList(tempList));
        }
        preOrderDfs(root.left, target);
        preOrderDfs(root.right, target);

        tempList.removeLast();
    }
}
