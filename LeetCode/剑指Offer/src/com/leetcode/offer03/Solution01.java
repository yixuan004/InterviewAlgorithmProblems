package com.leetcode.offer03;

/*
题目：
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    请找出数组中任意一个重复的数字。
示例：
    [2, 3, 1, 0, 2, 5, 3]
    输出：2 或 3
限制：
    2 <= n <= 100000
 */
public class Solution01 {
    public int findRepeatNumber(int[] nums) {
        int[] bucket = new int[100005]; // 根据数据范围的做法
        int result = -1; // 找不到的时候，返回-1

        for (int i = 0; i < nums.length; i++) {
            if (bucket[nums[i]] == 1) {
                result = nums[i];
            } else {
                bucket[nums[i]] = 1;
            }
        }

        return result;
    }
}
