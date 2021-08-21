package com.leetcode.offer58_2;

public class Solution02 {
    public String reverseLeftWords(String s, int n) {
        // 对Java中的substring切片函数尝试使用，注意这个substring是String类型数据的方法
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
