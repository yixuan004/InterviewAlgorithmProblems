package com.leetcode.offer03;

public class Solution03 {
    // 考虑到之前的HashSet方法，时间空间空间复杂度都是O(N)，所以如果面试提出需要空间复杂度O(1)解决的话，参考了网上的原地交换方法
    // 这种方法的特点要求是，最大的数字，不能超过数组长度！！！！！ 很关键，但题目好像没有说这一点？
    public int findRepeatNumber(int[] nums) {
        int result = -1;
        int i = 0;

        while (i < nums.length) {
            // 当前正好是nums[i] = i的，例如开局时，nums[0] = 0，这种情况要跳过，因为等于是首次出现
            if (nums[i] == i) {
                i ++;
                continue;
            }

            if (nums[i] == nums[nums[i]]) { // 预交换，发现已经在之前出现过一次了
                result = nums[i];
                break;
            } else { // 发现之前不相等，就真的要交换一下了
                int temp = nums[nums[i]]; // 空间复杂度为1，但利用到的其中最大数字不超过数组长度的特点？
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        return result;
    }
}
