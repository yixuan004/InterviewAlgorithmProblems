package com.leetcode.offer12;

/*
题目：
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

分析：
主要是还要想一下这个题为什么是深度优先搜索
广度优先走到每个位置的时候需要考虑这个位置下的多个方向，因为这些方向很有可能都是正确的路径
而这个题只需要考虑到正确的那个方向，所以深度优先就可以了，深度优先就是一种递归的感觉
 */
public class Solution01 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) { //  如果board一行都没有，直接return false
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = dfs(board, word, i, j, 0);
                if (result == true) {
                    return true;
                }
            }
        }

        return false; // 兜底逻辑
    }

    public boolean dfs(char[][] board, String word, int i, int j, int jishu) {
        if (!(i >= 0 && i < board.length && j >= 0 && j < board[0].length) || board[i][j] != word.charAt(jishu)) {
            // 如果i j不在这个范围内，那么是一个退出的结束条件，代表已经找出棋盘区间了
            // 如果不等了，即使jishu == word.length()-1也不行
            return false;
        }

        if (jishu == word.length() - 1) {
            // 满足的返回条件，这种时候代表有word.length()那个长度的都一样，代表找到那个词了
            return true;
        }

        // 在这里已经是默认  board[i][j] == word.charAt(jishu) 的状态了
        // 如果当前这个位置能满足条件，那么要开始接下来4个方向的dfs了，同时传jishu + 1那个
        board[i][j] = '\0'; // 这个位置在之后不能被访问到了，其实塞个其他的字母也是一样的，但是使用空字符比较保险

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int l = 0; l < 4; l++) {
            int nx = i + dx[l];
            int ny = j + dy[l];
            boolean result = dfs(board, word, nx, ny, jishu + 1);
            if (result == true) {
                return true; // 这种方法应该能起到剪枝效果吧
            }
        }

        // 回溯回来，dfs的基本写法
        board[i][j] = word.charAt(jishu);
        return false;
    }
}
