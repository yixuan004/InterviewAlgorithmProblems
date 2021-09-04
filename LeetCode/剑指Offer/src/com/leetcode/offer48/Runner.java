package com.leetcode.offer48;

public class Runner {
    public static void main(String[] args) {
        Solution01 s1 = new Solution01();
        String s = "abcabcbb";

        int result = s1.lengthOfLongestSubstring(s);
        System.out.println("result: " + result);
    }
}
