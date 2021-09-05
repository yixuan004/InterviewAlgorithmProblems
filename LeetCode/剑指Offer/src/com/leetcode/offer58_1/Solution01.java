package com.leetcode.offer58_1;

/*
题目：
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
为简单起见，标点符号和普通字母一样处理。
例如输入字符串"I am a student. "，则输出"student. a am I"。

示例：
输入: "the sky is blue"
输出: "blue is sky the"

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

笔记：
StringBuilder是个好东西，注意builder的拼写，以后以String类型的返回值，感觉都可以使用StringBuilder
 */
public class Solution01 {
    public String reverseWords(String s) {
        // 这个题题解用到了很多String的方法操作，需要学习下
        // java的String类型也是有trim 和 split方法的
        String[] strs = s.trim().split(" "); // trim和python中的strip是一样的，split中要求String作为参数输入
        StringBuilder strBuilder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0 ; i --) {
            strs[i] = strs[i].trim();
            if (strs[i].length() != 0) {
                if (i != 0) {
                    strBuilder.append(strs[i] + " ");
                } else {
                    strBuilder.append(strs[i]);
                }
            }
        }
        // System.out.println("string builder: " + strBuilder);
        return strBuilder.toString(); // string builder 的toString方法
    }
}
