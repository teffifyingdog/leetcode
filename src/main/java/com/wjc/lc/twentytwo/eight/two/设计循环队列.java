package com.wjc.lc.twentytwo.eight.two;

import java.util.Stack;

public class 设计循环队列 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
        circularQueue.isFull(); // 返回 true
        circularQueue.deQueue(); // 返回 true
        circularQueue.enQueue(4); // 返回 true
        circularQueue.Rear(); // 返回 4

    }
}

class MyCircularQueue {


    private Stack<Integer> stack = new Stack();
    private int size = 0;

    public MyCircularQueue(int k) {
        size = k;
    }

    public boolean enQueue(int value) {
        if (stack.size() == size) {
            return false;
        }
        stack.push(value);
        return true;
    }

    public boolean deQueue() {
        if (stack.size() == 0) {
            return false;
        }
        stack.remove(0);
        return true;
    }

    public int Front() {
        if (stack.size() == 0) {
            return -1;
        }
        return stack.get(0);
    }

    public int Rear() {
        if (stack.size() == 0) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        if (stack.size() == size) {
            return true;
        }
        return false;
    }
}