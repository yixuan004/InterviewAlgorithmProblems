package com.leetcode.offer50;

import java.util.*;

/*
题目：
    在字符串 s 中找出第一个只出现一次的字符。
    如果没有，返回一个单空格。
    s 只包含小写字母。

示例：
    s = "abaccdeff"
    返回 "b"

    s = ""
    返回 " "

提示：
    0 <= s 的长度 <= 50000
 */
public class Solution01 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        char result = ' ';

        // 首次遍历s，计数上
        for (int i = 0; i < s.length(); i++) {
            if (dict.containsKey(s.charAt(i))) { // 如果dict中已经包含这个了，注意这个方法 dict.containsKey();
                int tempCount = dict.get(s.charAt(i)) + 1;
                dict.put(s.charAt(i), tempCount);
            } else {
                dict.put(s.charAt(i), 1);
            }
        }

        // 二次遍历s，把这些东西判断取出来
        for (int i = 0; i < s.length(); i++) {
            if (dict.containsKey(s.charAt(i))) {
                if (dict.get(s.charAt(i)) == 1) {
                    result = s.charAt(i);
                    break;
                }
            } else {
                System.out.println("自认为不可能发生的情况出现，需要检查");
            }
        }

        return result;
    }
}
