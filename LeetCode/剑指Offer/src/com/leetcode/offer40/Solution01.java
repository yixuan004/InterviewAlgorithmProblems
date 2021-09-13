package com.leetcode.offer40;

import java.util.*;

public class Solution01 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i ++) {
            result[i] = arr[i];
        }
        return result;
    }
}
