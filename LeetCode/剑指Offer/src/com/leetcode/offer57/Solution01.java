package com.leetcode.offer57;

public class Solution01 {
    public int[] twoSum(int[] nums, int target) {
        // 分析题目，是一个递增序列和一个数字s，查找两个数，而且不要求这两个数字的顺序，那么估计是要求o(n)的

        // 先随缘尝试一个o(n^2)的方法，发现超出时间限制了
        /*
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                }
            }
        }
        return result;
        */
        // 寻找一个O(n)的方法，比较简单，有点像那个矩阵中寻找一个数字，要保证一边增加一边减小的感觉
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            } else if (nums[left] + nums[right] < target) {
                left ++;
            } else if (nums[left] + nums[right] > target) {
                right --;
            }
        }

        return result;
    }
}
