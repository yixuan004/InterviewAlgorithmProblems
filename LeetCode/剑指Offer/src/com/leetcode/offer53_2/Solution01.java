package com.leetcode.offer53_2;

/*
题目：
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

示例：
输入: [0,1,3]
输出: 2

提示：
1 <= 数组长度 <= 10000
 */
public class Solution01 {
    // 自己的题目分析来看，就像是找到把那个missing的数字，插入到哪里一样，二分查到找到那个位置
    // 查找第一个nums[i] != i 的
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                // 正常情况，也就是说那个现象还没出现
                left = mid + 1;

            } else if (nums[mid] > mid){
                // 在之前某个位置，出现了
                right = mid - 1;
            } else { // nums[mid] < mid，应该没有这种情况吧，加一句输出打印查看
                System.out.println("自认为不可能出现的情况出现了");
            }
        }
        // System.out.println("left: " + left);
        // System.out.println("right: " + right);

        // 最终的left，是最后一个相等状态下角标+1后的结果，也就是不等的那个位置
        // 最终的right，是从右看最后一个不相等状态下角标-1后的结果，也就是相等的那个位置
        // return left;
        return right + 1; // 也可
    }
}
