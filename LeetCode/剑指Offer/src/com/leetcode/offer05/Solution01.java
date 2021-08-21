package com.leetcode.offer05;

import java.util.ArrayList;


// 主要是练习基于java的语法，这个怎么写的感觉
public class Solution01 {
    public String replaceSpace(String s) {
        char[] charArray = s.toCharArray();
        char[] returnCharArray = new char[charArray.length * 3]; // 最多是全部替换为空格
        int index = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                returnCharArray[index++] = '%';
                returnCharArray[index++] = '2';
                returnCharArray[index++] = '0';
            } else {
                returnCharArray[index++] = charArray[i];
            }
        }
        String returnString = new String(returnCharArray, 0, index);

        // System.out.println(returnString);
        return returnString;
    }
}
