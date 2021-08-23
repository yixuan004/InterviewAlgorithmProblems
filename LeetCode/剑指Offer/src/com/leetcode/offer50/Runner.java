package com.leetcode.offer50;

public class Runner {
    public static void main(String[] args) {
        String s = "abaccdeff";

        Solution01 s1 = new Solution01();
        char result1 = s1.firstUniqChar(s);
        System.out.println("result1: " + result1);


        Solution02 s2 = new Solution02();
        char result2 = s2.firstUniqChar(s);
        System.out.println("result2: " + result2);


    }
}
