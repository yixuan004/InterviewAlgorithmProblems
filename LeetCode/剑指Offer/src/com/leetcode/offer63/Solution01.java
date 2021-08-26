package com.leetcode.offer63;

/*
题目：
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

示例：
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。


 */
public class Solution01 {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxPf = 0;

        for (int i = 0; i < prices.length; i++) {
            if ((prices[i] - minValue) < 0) {
                minValue = prices[i];
            } else {
                if ((prices[i] - minValue) > maxPf) {
                    maxPf = prices[i] - minValue;
                }
            }
        }

        return maxPf;
    }
}
