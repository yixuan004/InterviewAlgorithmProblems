package com.leetcode.offer11;

/*
题目：
    找到旋转数组中最小的数字
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
    例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

示例：
    输入：[3,4,5,1,2]
    输出：1

    输入：[2,2,2,0,1]
    输出：0
 */
public class Solution01 {
    public int minArray(int[] numbers) {
        // 只要具有这种递增递减顺序的特点，都可以看做二分查找题的变种
        int result;

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) { // 这里也可以写成小于等于，但是由于最后还会走一轮，那么left = right + 1，而此时right可能为-1越界
            int mid = (left + right) / 2;
            /* 这里需要明确下判断方法：
            一定要使用right进行判断，因为其是可以确定的
            ① 如果mid小于right，则一定在[left, mid]区间中
            ② 如果mid大于right，则一定在[mid+1, right]区间中

            为什么不能用left判断？
            ① 如果mid大于left，那么可能在左边，可能在右边，就要不能二分了
            [1(target), 2, 3, 4(mid), 5, 6, 7]
            [3, 4, 5, 6(mid), 7, 1(target), 2]
            ② 如果mid小于left，那么一定在左边[left, mid]
             */
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else { // numbers[mid] == numbers[right]
                // 这里考虑的case是[3(left), 3(mid), 1, 3(right)]，[0(left), 1(mid), 1, 1(right)]
                // case1可以抛弃right不能抛弃right~mid区间，case2不能抛弃left，因为连续的话，还是要从最右开刀
                right--;
            }
        }
        // System.out.printf("left: %d, right: %d\n", numbers[left], numbers[right]);
        return numbers[left]; // 循环条件写while(<)返回left和right是一样的，而如果写 <=，由于right--的操作，只能返回left
    }
}
