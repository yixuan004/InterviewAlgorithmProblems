package com.leetcode.offer50;

import java.util.*;

public class Solution02 {
    public char firstUniqChar(String s) {
        // 第二种方法，有序的HashMap，LinkedHashMap的用法
        // 注，速度还是慢，有些怀疑是没有toCharArray的问题
        char result = ' ';

        Map<Character, Integer> orderDict = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (orderDict.containsKey(s.charAt(i))) {
                int tempCount = orderDict.get(s.charAt(i)) + 1;
                orderDict.put(s.charAt(i), tempCount);
            } else {
                orderDict.put(s.charAt(i), 1);
            }
        }


        // 按orderDict.put的顺序遍历orderDict，这里用到了Map.Entry和，orderDict.entrySet()
        for (Map.Entry<Character, Integer> entry: orderDict.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }

        return result;
    }
}
