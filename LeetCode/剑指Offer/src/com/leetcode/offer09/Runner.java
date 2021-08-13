package com.leetcode.offer09;

public class Runner {
    public static void main(String[] args) {
        CQueue q1 = new CQueue();
        q1.appendTail(1);
        q1.appendTail(2);
        q1.appendTail(3);
        System.out.println(q1.deleteHead());

        System.out.println("================");

        CQueue02 q2 = new CQueue02();
        q2.appendTail(1);
        q2.appendTail(2);
        q2.appendTail(3);
        System.out.println(q2.deleteHead());

    }
}
