package com.leetcode.offer63;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};

        Solution01 s1 = new Solution01();
        int result = s1.maxProfit(nums);
        System.out.println("result: " + result);
    }
}
