package com.leetcode.offer46;

public class Solution01 {
    // 该道题的思想是，初始化dp[]数组
    // 当前位置如果能和前一个位置组合成一个10-z的数字，则dp[i] = dp[i-1] + dp[i-2]（有一种^2的感觉了）
    // 如果当前位置不能和之前的组成，则dp[i] = dp[i-1]
    public int translateNum(int num) {
        String numString = String.valueOf(num); // 用这个方法把一个整型数字转化为String
        // System.out.println(numString);

        int[] dp = new int[numString.length()]; // 初始化一个dp数组
        dp[0] = 1; // 如果只有一位的话，因为是从0翻译成a的，那么必有一种翻译方法

        for (int i = 1; i < numString.length(); i ++) {
            // 如果当前位置和前一位置能组成一个字符，f(i-1) + f(i-2)
            // 这里有一些String的操作，需要在学习下
            String tmpString = numString.substring(i - 1, i + 1); // substring中的string小写
            // System.out.println("tmpString: " + tmpString);
            if (tmpString.compareTo("10") >= 0 && tmpString.compareTo("25") <= 0) {
                if (i == 1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else { // f(i-1)和上一个状态的转移方案一样
                dp[i] = dp[i - 1];
            }
        }
        return dp[numString.length() - 1];
    }
}
