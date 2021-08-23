package com.leetcode.offer50;

import java.util.*;

public class Solution03 {
    public char firstUniqChar(String s) {
        // 在尝试后发现也不是toCharArray的问题，可能是没有用boolean的问题，留待未来复盘这个题的时候解决了
        char result = ' ';
        char[] charArray = s.toCharArray();
        Map<Character, Integer> orderDict = new LinkedHashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            if (orderDict.containsKey(charArray[i])) { // 如果有了
                int temp = orderDict.get(charArray[i]) + 1;
                orderDict.put(charArray[i], temp); // 加1后放回去
            } else {
                orderDict.put(charArray[i], 1);
            }
        }

        // 按照插入顺序遍历LinkedHashMap（事实上是所有Map）
        for (Map.Entry<Character, Integer> entry: orderDict.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }

        return result;
    }
}
