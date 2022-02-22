package com.wjc.lc.twenty.two.twentyfive;


import java.util.Stack;

class 最小栈 {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> minData = new Stack<>();

    /**
     * 链接
     *  https://leetcode-cn.com/problems/min-stack/
     */
    public 最小栈() {

    }

    public void push(int x) {
        if (minData.isEmpty() || minData.peek() > x){
            minData.push(x);
        }
        data.push(x);
    }

    public void pop() {
        if (data.pop() == minData.peek()) {
            minData.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}

class test{
    public static void main(String[] args) {
        最小栈 zxz = new 最小栈();
        zxz.push(-2);
        zxz.push(0);
        zxz.push(-3);
        int min = zxz.getMin();
        System.out.println("min = " + min);
        zxz.pop();
        System.out.println(zxz.top());
        System.out.println(zxz.getMin());

    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */