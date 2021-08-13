package com.leetcode.offer09;

/*
题目说明：
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
(若队列中没有元素，deleteHead 操作返回 -1 )

示例1
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]

示例2
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

数据范围
1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用
 */

import java.util.ArrayList;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
public class CQueue {

    ArrayList<Integer> list;

    public CQueue() {
        // 创建对象的时候才实例化
        list = new ArrayList<>();
    }

    public void appendTail(int value) {
        list.add(value);
    }

    public int deleteHead() {
        if (list.size() != 0) {
            return list.remove(0);
        } else {
            return -1;
        }
    }
}
