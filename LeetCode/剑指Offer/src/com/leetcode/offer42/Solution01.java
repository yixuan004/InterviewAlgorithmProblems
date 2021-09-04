package com.leetcode.offer42;

public class Solution01 {
    // 这个题的思路还是需要综合判断各种情况，把每个情况都列出来就好了
    public int maxSubArray(int[] nums) {
        // 题目给出了arr.length >= 1
        int resultMaxValue = nums[0];
        int nowMaxValue = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] >= 0) { // 当前这个位置数字大于等于0的情况，代表很有可能要更新nowMax了
                if (nowMaxValue < 0) {
                    nowMaxValue = nums[i]; // 如果当前的nowMaxValue小于0，用这个更新当前的nowMax，实际上就是以这个作为新的起点了
                } else {
                    nowMaxValue += nums[i]; // 如果当前的nowMaxValue大于0，而这个数字也大于0，那么必将更新nowMaxValue
                }
            } else { // 当前这个位置数字小于0的情况
                if (nowMaxValue < 0) {
                    if (nums[i] > nowMaxValue) {
                        nowMaxValue = nums[i]; // 针对[-2, -1]的case
                    }
                } else {
                    nowMaxValue += nums[i]; // 因为要求连续，所以这里肯定要加的
                }
            }
            // 每轮操作完成后，判断这个nowMax（走到当前位置的max）
            if (nowMaxValue > resultMaxValue) {
                resultMaxValue = nowMaxValue;
            }
        }
        return resultMaxValue;
    }
}
