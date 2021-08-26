package com.leetcode.offer10_2;

/*
题目：
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例：
输入：n = 2
输出：2

 */
public class Solution01 {
    public int numWays(int n) {
        // 这种明显的题，找通项公式 dp[i] = dp[i-1] + dp[i-2]
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            int f0 = 1;
            int f1 = 1;
            int temp = 1;
            for (int i = 2; i <= n; i++) {
                temp = (f0 + f1) % 1000000007;
                f0 = f1;
                f1 = temp;
            }
            return temp;
        }
    }
}
