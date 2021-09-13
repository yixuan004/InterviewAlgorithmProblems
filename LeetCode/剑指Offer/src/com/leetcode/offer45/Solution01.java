package com.leetcode.offer45;

import java.util.*;

public class Solution01 {
    public String minNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        String[] strNums = new String[nums.length]; // 这里用[]
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // 直接调用Arrays的操作，进行字符串的比较
        // 这里String是引用类型可以用来直接比，这里比较字典序
        // 这个字典序比较的方式【非常巧妙】，需要记录下，两者相加后要把字典序更小的排在前边
        Arrays.sort(strNums, (x, y) -> {
            return (x + y).compareTo(y + x);
        });

        for (int i = 0; i < strNums.length; i++) {
            // System.out.println(strNums[i]);
            result.append(strNums[i]);
        }
        return result.toString();
    }
}
