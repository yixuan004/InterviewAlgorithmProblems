package com.leetcode.offer61;

import java.util.*;

public class Solution01 {
    public boolean isStraight(int[] nums) {
        Integer[] numsInteger = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsInteger[i] = Integer.valueOf(nums[i]);
        }
        Arrays.sort(numsInteger, (p, q) -> {
            return p - q;
        });
        int countZero = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (numsInteger[i].intValue() == 0) {
                countZero ++;
                continue;
            } else {
                int temp = numsInteger[i + 1].intValue() - numsInteger[i].intValue();
                if (temp == 0) {
                    return false;
                } else if (temp == 1) {
                    continue;
                } else if (temp > countZero) {
                    return false;
                } else {
                    countZero -= temp; // 把大小王填空
                }
            }
        }
        return true;
    }
}
