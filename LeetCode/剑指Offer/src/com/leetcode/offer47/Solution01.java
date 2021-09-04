package com.leetcode.offer47;

public class Solution01 {
    public int maxValue(int[][] grid) {
        // 初始化一个size完全相同的dp，每个位置代表走到这个位置处所能拿到最大价值的礼物
        int[][] dp = new int[grid.length][grid[0].length];

        // 第一列初始化赋值，要累加上去
        for (int i = 0; i < grid.length; i ++) {
            if (i == 0) {
                dp[i][0] = grid[i][0];
            } else {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

        }
        // 第一行初始化赋值，要累加上去
        for (int j = 0; j < grid[0].length; j ++) {
            if (j == 0) {
                dp[0][j] = grid[0][j];
            } else {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
        }

        // 遍历的操作，因为是向右或者向下，所以只要每行遍历就可以了
        for (int i = 1; i < grid.length; i ++) {
            for (int j = 1; j < grid[0].length; j ++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        // for (int i = 0; i < grid.length; i ++) {
        //     for (int j = 0; j < grid[0].length; j ++) {
        //         System.out.printf("%d ", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}