package com.leetcode.offer53_1;

/*
题目：
统计一个数字在排序数组中出现的次数。

示例：
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2

提示：
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums 是一个非递减数组
-10^9 <= target <= 10^9

 */
public class Solution01 {
    // 普通遍历法，时间复杂度O(N)
    public int search(int[] nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count ++;
            }
        }

        return count;
    }
}
