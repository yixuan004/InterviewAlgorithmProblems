package com.leetcode.offer03;

import java.util.HashSet;
import java.util.Set;

public class Solution02 {
    public int findRepeatNumber(int[] nums) {
        // 使用java中的hashset的方法，这样可以进一步避免对数组长度的依赖
        Set<Integer> set = new HashSet<>();
        int result = -1;

        for (int num: nums) {
            if (set.add(num) == false) { // hashset.add(E e)：返回boolean型，如果此 set 中尚未包含指定元素，则添加指定元素；如果此 set 已包含该元素，则该调用不更改 set 并返回 false。
                result = num;
                break;
            }
        }

        return result;
    }
}
