package com.nowcoder.mt2021.contest01;

import java.util.*;

/*
美团对于商家的评价体系是1-5星评价体系，用户在完成订单之后可以对商家打1/2/3/4/5星，而在客户端上，商家的评级却不一定是整数，而是会显示小数点后的一位。很显然这就需要一个计算器了，小美拥有了一些商户的评价数据，希望可以计算出商家在客户端上显示出的评分。
这个评分的计算非常简单，就是对该商家的所有客户的星级评价做求一个平均，然后去尾法显示小数点后的一位即可，例如平均得分是3.55，则显示的是3.5。例如某商家获得了1-5星评价各一个，则显示的评分是(1+2+3+4+5)/5=3.0。
如果商家没有获得评价，则显示0.0。
 */
public class Solution02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalCount = 0;
        double total = 0;
        for (int i = 0; i < 5; i++) {
            int temp = sc.nextInt();
            totalCount += temp;
            total += temp * (i + 1);
        }
        // 先乘10再floor的思路
        total = total / totalCount;
        total *= 10;
        total = Math.floor(total);
        System.out.println(total / 10);
    }
}
