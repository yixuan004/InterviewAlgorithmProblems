package com.leetcode.offer64;

/*
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution01 {
    // 第一种方法，使用乘法的方法，不符合要求
    /*
    public int sumNums(int n) {
        return ((1 + n) * n) / 2;
    }
     */

    // 第二种方法，比较容易想到的递归法，但由于用到了if还是不满足题目要求
    /*
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n - 1);
    }
     */

    // 第三种方法，使用&&过程中的短路效应，如果第一个不满足了就直接退出，这个想法还是非常巧妙的
    // 更加简洁的写法
//    public int sumNums(int n) {
//        boolean x = (n > 1) && (n += sumNums(n - 1)) > 0; // 需要设置一个x来实现这个短路效应，后边是一个永真的式子
//        return n;
//    }

    // 更容易想到的借助result的写法
    int result = 0;
    public int sumNums(int n) {
        // 这里会不断增加栈的深度
        boolean x = (n > 1) && sumNums(n - 1) > 0;
        // 这里出栈不断累加
        result += n;
        return result;
    }
}
