package com.leetcode.offer34;

import java.util.*;

public class Solution02 {
    // 注意这里是全局的，并且使用ArrayList
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();

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

        tempList.remove(tempList.size() - 1); // ArrayList删除最后一个
    }
}
