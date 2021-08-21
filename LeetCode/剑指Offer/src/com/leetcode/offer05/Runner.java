package com.leetcode.offer05;

public class Runner {
    public static void main(String[] args) {
        Solution01 s1 = new Solution01();
        String s = new String("We are happy.");
        System.out.println(s);
        String result = s1.replaceSpace(s);
        System.out.println(result);
    }
}
