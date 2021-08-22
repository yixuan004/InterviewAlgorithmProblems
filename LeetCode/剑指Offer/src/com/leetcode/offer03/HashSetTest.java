package com.leetcode.offer03;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet hset = new HashSet();

        hset.add(1);
        hset.add("Hello");
        hset.add("c");
        int[] nums = {1, 2, 3, 4, 5};
        hset.add(nums);

        // 使用iterator进行遍历
        Iterator it = hset.iterator();
        while (it.hasNext()) {
            Object obj = it.next(); // 取到Object
            // instanceof 测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型。
            if (obj instanceof Integer) {
                System.out.println("Integer: " + obj);
            } else if (obj instanceof String) {
                System.out.println("String: " + obj);
            } else if (obj instanceof Character) {
                System.out.println("Character: " + obj);
            } else if (obj instanceof int[]) {
                System.out.println("int[]: ");
                for (int i = 0; i < nums.length; i++) { // 这里的名称要和上边的对应？R
                    System.out.println(nums[i] + " ");
                }
            }
        }
    }
}
