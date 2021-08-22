package com.leetcode.offer53_1;

// 在Solution02的基础上进一步优化，主要思想是通过二分查找来找到左右边界！ 这样左右边界的index直接减在一起就是答案了
// 这种解法比较巧妙，需要之后复习下
public class Solution03 {
    public int search(int nums[], int target) {

        // 这里还隐藏了两种方法

        /*
        // 方法一如下：
        // 第一个大于目标数字的角标
        int right = binarySearchRightEnd(nums, target);
        // 第一个大于目标数字-1的角标，如果目标数字存在，则是目标数字的起始，不存在则同right
        // 如果是1 2 3 3 3 ，target是3的情况，那么left会等于5，因为终止条件是left>right！
        int left = binarySearchRightEnd(nums, (target-1));
        return right - left;
         */

        // 方法二如下：
        int right = binarySearchRightEnd(nums, target);
        int left = binarySearchLeftEnd(nums, target);
        return right - left - 1;

    }

    public int binarySearchRightEnd(int[] nums, int binSearchTarget) {
        /*
        二分查找模板上的一个改动，目标是寻找到第一个比binSearchTarget这个数字大的位置
         */
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) { // 二分查找的模板套路
            int mid = (left + right) / 2;
            //  这里分三段写更容易理解，自己不要把情况合并到一块了
            if (nums[mid] < binSearchTarget){
                left = mid + 1;
            } else if (nums[mid] > binSearchTarget){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left; // 这个地方的数字，是第一个大于目标数字的角标
    }

    public int binarySearchLeftEnd(int[] nums, int binSearchTarget) {
        /*
        二分查找模板上的一个改动，找到第一个比binSearchTarget小的数字，可能会返回-1
         */
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < binSearchTarget) {
                left = mid + 1;
            } else if (nums[mid] > binSearchTarget) {
                right = mid - 1;
            } else {
                // 主要是这里很关键，为了找到左边界，要right-1
                right = mid - 1;
            }
        }

        return right;
    }
}
