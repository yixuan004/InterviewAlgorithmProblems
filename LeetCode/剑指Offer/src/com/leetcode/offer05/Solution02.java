package com.leetcode.offer05;

public class Solution02 {
    public String replaceSpace(String s) {
        char[] returnCharArray = new char[s.length() * 3];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                returnCharArray[index++] = '%';
                returnCharArray[index++] = '2';
                returnCharArray[index++] = '0';
            } else {
                returnCharArray[index++] = s.charAt(i);
            }
        }

        return new String(returnCharArray, 0, index); // 注意这里的从array的构造方法！
    }
}
