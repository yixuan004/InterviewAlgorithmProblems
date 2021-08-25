package com.leetcode.offer27;

import java.util.*;

public class Solution02 {
    public TreeNode mirrorTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>(); // 用Deque模拟stack

        if (root != null) {
            stack.push(root);
        }

        // 与之前某次复制链表的操作不太一样，这个完全是在
        while (stack.size() != 0) {
            // 把栈顶元素弹出来
            TreeNode nowRoot = stack.pop();
            // 把左子，右子依次入栈
            if (nowRoot.left != null) {
                stack.push(nowRoot.left);
            }
            if (nowRoot.right != null) {
                stack.push(nowRoot.right);
            }
            // 对当前pop出来的这个节点，左右两边重新组织一下（等于在原有的基础上修改）
            TreeNode origLeft = nowRoot.left; // 暂存栈顶元素的左子树位置
            nowRoot.left = nowRoot.right;
            nowRoot.right = origLeft;
        }
        return root;
    }

    public void levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        if (root != null) {
            queue.add(root);
        }
        while (queue.size() != 0) {
            list.add(queue.peek().val);
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            queue.poll();
        }
        System.out.println(list);
    }
}
