package com.leetcode.offer04;

/*
题目：
    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例：
    [
      [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
      [10, 13, 14, 17, 24],
      [18, 21, 23, 26, 30]
    ]
    给定 target = 5，返回 true。
    给定 target = 20，返回 false。

限制：
    0 <= n <= 1000
    0 <= m <= 1000
 */
public class Solution01 {
    // 这个题要记住，要从右上角开始，才能保证一减一增那个感觉
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 异常检测，如果是空矩阵
        if (matrix.length == 0) { // 行为0，则直接false
            return false;
        } else {
            int i = 0;
            int j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                // System.out.printf("matrix[%d][%d]: %d\n", i, j, matrix[i][j]);
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    j--;
                } else if (matrix[i][j] < target) {
                    i++;
                }
            }
            return false;
        }
    }
}
