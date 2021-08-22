package com.leetcode.offer53_1;

// 自己的第二种方法，先用二分查找，在之后从二分查找到的位置向左向右分别查找
// 但是在极端case的情况下，这种仍然没有避免时间复杂度O(N)的问题，实际上应该用两次二分查找，找到两边的边界
public class Solution02 {
    public int search(int[] nums, int target) {
        // 因为题目中说明了数组单调的特点，这里用二分法做一个尝试
        int left = 0; // 左边
        int right = nums.length - 1; // 右边
        int index = -1; // 兼职findFlag的作用
        int count = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1; // 注意这里的改变方式
            } else {
                left = mid + 1; // 注意这里的改变方式
            }
        }

        // System.out.println("index output: " + index);
        if (index != -1) { // 如果能找到，就从index往两边找一下
            count++; // 把本来这个位置上的加上
            for (int i = index + 1; i < nums.length && nums[i] == target; i++) {
                count++;
            }
            for (int i = index - 1; i >= 0 && nums[i] == target; i--) {
                count ++;
            }
        }

        return count;
    }
}
