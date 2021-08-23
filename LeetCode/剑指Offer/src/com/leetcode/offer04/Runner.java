package com.leetcode.offer04;

public class Runner {
    public static void main(String[] args) {
        int[][] matrix =  {{1, 4, 7, 11, 15},
                           {2, 5, 8, 12, 19},
                           {3, 6, 9, 16, 22},
                           {10, 13, 14, 17, 24},
                           {18, 21, 23, 26, 30}};
        int target = 36;

        Solution01 s1 = new Solution01();
        boolean flag = s1.findNumberIn2DArray(matrix, target);
        System.out.println("flag: " + flag);
    }
}
