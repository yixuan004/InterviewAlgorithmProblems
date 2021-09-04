package com.leetcode.offer48;

import java.util.*;

public class Solution01 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        // Map<Character, Integer> orderDict = new LinkedHashMap<>(); // 这个是OrderDict，习惯上来说两个都可以
        Map<Character, Integer> dict = new HashMap<>();
        int[] dp = new int[s.length()]; // 每次建立dp数组的时候要明确dp数组的含义，这个地方的含义是以【这个Character作为结尾】的最大长度！！！！！
        dp[0] = 1; // 至少有一个长度为1的，之后从1开始
        dict.put(s.charAt(0), 0); // 初始化
        int maxLength = 1; // 由于dp每个位置处代表以这个Character为结尾的最大长度，所以还需要筛一下最大的

        for (int i = 1; i < s.length(); i ++) {
            // 代表这个字母出现的上一个位置
            // 这里也可以使用getOrDefault，多传一个default参数即可
            int lastCharIndex = dict.getOrDefault(s.charAt(i), -1); // 如果不使用getOrDefault，会出现nullPointer

            if (lastCharIndex == -1) { // 如果这个字母在之前没出现过，则直接把上一个位置的最大长度加上这个
                dp[i] = dp[i-1] + 1;
                // 更新put进去
                dict.put(s.charAt(i), i);

            } else { // 如果这个字母在之前出现过
                // dp[i-1]处存储了以i-1那个位置处为结尾的最长字符串长度
                // 所以如果lastCharIndex在那个位置之外，则dp[i] = dp[i-1] + 1; abbca（这次a出现，上一个位置c是2）
                // 否则dp[i] = i - lastCharIndex; 由上一个位置来确定的
                if ((i - lastCharIndex) > dp[i - 1]) {
                    dp[i] = dp[i-1] + 1;
                } else {
                    dp[i] = i - lastCharIndex;
                }
                // 更新
                dict.put(s.charAt(i), i);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
