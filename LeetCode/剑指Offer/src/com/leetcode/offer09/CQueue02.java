package com.leetcode.offer09;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class CQueue02 {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue02() {
        // 这种是栈的实现，以后的栈就都这么用就行了
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        // 每当delete的时候，如果stack1是空，才把stack2往stack1倒一下
        if (stack1.size() == 0) {
            while (stack2.size() != 0) {
                stack1.push(stack2.pop());
            }
        }

        if (stack1.size() != 0) {
            return stack1.pop();
        } else {
            return -1;
        }
    }
}
