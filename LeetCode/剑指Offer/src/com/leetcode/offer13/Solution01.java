package com.leetcode.offer13;

import java.util.*;

public class Solution01 {
    public int movingCount(int m, int n, int k) {
        // 如何判断这个题是一个广度优先搜索？确实不太好判断，但是这种有多条路线的感觉广和深都可以？ 或者说因为不需要记录连续的状态，而用广度优先？
        int result = 0;

        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new LinkedList<>(); // 广度优先代码写起来感觉比深度优先还简单一些，基本就是借助队列，在之前的练习中队列，栈基本都用双端队里deque实现了

        // 把初始状态放进去，代表当前从0，0这个位置开始出发，这种写法稍微封装一下，否则需要使用queue.add
        int[] start = {0, 0};
        queue.add(start);
        visited[0][0] = true;
        result++;

        // 每次可以向左右上下移动
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (queue.size() != 0) {
            int[] temp = queue.poll(); // 把队头元素取出来并且pop掉
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 判断能否进入到这个方格，并且要求这个方格不曾被访问过
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && visited[nx][ny] == false && judge(nx, ny, k)) {
                    visited[nx][ny] = true;
                    result++;
                    int[] temp1 = {nx, ny};
                    queue.add(temp1);
                }
            }
        }
        return result;
    }

    public boolean judge(int a, int b, int k) {
        // 判断a和b按照位数相加的时候和k的大小比较
        int sumA = 0;
        while(a > 0) {
            sumA += a % 10;
            a /= 10;
        }

        int sumB = 0;
        while (b > 0) {
            sumB += b % 10;
            b /= 10;
        }

        if (sumA + sumB > k) {
            return false;
        }
        return true;
    }
}
