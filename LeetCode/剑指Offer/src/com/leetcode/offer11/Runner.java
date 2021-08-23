package com.leetcode.offer11;

public class Runner {
    public static void main(String[] args) {

        int[] numbers = {0, 1, 1, 1, 2, 3, 4};

        Solution01 s1 = new Solution01();
        int result = s1.minArray(numbers);
        System.out.println("result: " + result);
    }
}
