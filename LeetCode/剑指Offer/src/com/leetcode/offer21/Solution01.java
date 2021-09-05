package com.leetcode.offer21;

public class Solution01 {
    public int[] exchange(int[] nums) {
        // 输入一个整数数组，实现一个函数让数组的【前半部分都是奇数】，【后半部分都是偶数】
        if (nums.length == 0) {
            return nums;
        } else {
            //  不出意外的话这种类型的题目时间复杂度应该都是O(n)的
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] % 2 == 0) {
                    // 如果当前这个位置是偶数，需要从右边找到第一个奇数，换过来，换了后left ++；
                    while(left < right) {
                        if (nums[right] % 2 != 0) {
                            int temp = nums[right];
                            nums[right] = nums[left];
                            nums[left] = temp;
                            break;
                        }
                        right -- ;
                    }
                }
                left ++;
            }
        }
        // for (int i = 0; i < nums.length; i ++) {
        //     System.out.println(nums[i]);
        // }
        return nums;
    }
}
