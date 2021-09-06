package com.leetcode.offer12;

public class Runner {
    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        String word = "ASD";
        Solution01 s1 = new Solution01();
        boolean result = s1.exist(board, word);
        System.out.println("result: " + result);
    }
}
