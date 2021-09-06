package com.leetcode.offer12;

public class Solution02 {
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

        // 这种写法好像不是自己之前的常用写法，但是慢慢学一下这种写法吧，代表四个方向只要有一个可以的就是可以的，注意这里是4个方向
        boolean result = dfs(board, word, i + 1, j, jishu + 1) || dfs(board, word, i - 1, j, jishu + 1)
                || dfs(board, word, i, j + 1, jishu + 1) || dfs(board, word, i, j - 1, jishu + 1);

        // 回溯回来，dfs的基本写法
        board[i][j] = word.charAt(jishu);
        return result;
    }
}
