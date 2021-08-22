package com.leetcode.offer03;

public class Runner {
    public static void main(String[] args) {
        Solution01 s1 = new Solution01();
        int[] nums = {1, 2, 3, 4, 5, 2};
        int result1 = s1.findRepeatNumber(nums);
        System.out.println("result1: " + result1);

        Solution02 s2 = new Solution02();
        int result2 = s2.findRepeatNumber(nums);
        System.out.println("result2: " + result2);

        Solution03 s3 = new Solution03();
        int[] nums3 = {2, 3, 5, 4, 1, 2};
        int result3 = s3.findRepeatNumber(nums3);
        System.out.println("result3: " + result3);
    }
}
