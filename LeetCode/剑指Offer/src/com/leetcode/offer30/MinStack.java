package com.leetcode.offer30;

/*
题目说明：
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数
在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

API操作解法在这个文件中
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
public class MinStack {

    /** initialize your data structure here. */
    Deque<Integer> stack;
    Deque<Integer> minValueStack;

    public MinStack() {
        stack = new LinkedList<>();
        minValueStack = new LinkedList<>(); // 用来存储非严格降序的stack
    }

    public void push(int x) {
        // push到主栈中
        stack.push(x);

        // 维护minValueStack
        if (minValueStack.size() == 0 || minValueStack.peek() >= x) {
            minValueStack.push(x);
        }

    }

    public void pop() {
        if (stack.size() != 0){
            int temp = stack.peek();
            stack.pop();
            if (minValueStack.peek() == temp) { // 两者同进退，这里不会抛出空指针，暂时不进行异常处理了
                minValueStack.pop();
            }
        } else {
            System.out.println("主栈已空，无法pop");
        }
    }

    public int top() {
        /*
        .peek()方法说明：
        @return the head of the queue represented by this deque, or
        {@code null} if this deque is empty

        这个方法不会pop掉，只是返回一个top
         */
        if (stack.size() != 0) {
            return stack.peek();
        } else {
            System.out.println("主栈为空，不能执行top操作");
            return -1;
        }
    }

    public int min() {
        // 需要思考下的地方在于，之前的最小值已经被pop掉了！
        //  所以要引入一个额外的栈来干这个维护的事情
        if (minValueStack.size() != 0) {
            return minValueStack.peek();
        } else {
            System.out.println("副栈为空（往往也代表着主栈为空），不支持min操作");
            return -1;
        }
    }
}
