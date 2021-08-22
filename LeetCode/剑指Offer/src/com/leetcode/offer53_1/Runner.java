package com.leetcode.offer53_1;

public class Runner {
    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;

        Solution01 s1 = new Solution01();
        int result1 = s1.search(nums1, target1);
        System.out.println("result1: " + result1);

        Solution02 s2 = new Solution02();
        int result2 = s2.search(nums1, target1);
        System.out.println("result2: " + result2);
    }
}
