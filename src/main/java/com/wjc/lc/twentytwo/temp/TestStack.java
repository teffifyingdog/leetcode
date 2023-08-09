package com.wjc.lc.twentytwo.temp;

import java.util.Stack;

public class TestStack {
    private Stack<Integer> stack =  new Stack<>();
    private Stack<Integer> minStack =  new Stack<>();
    private Stack<Integer> maxStack =  new Stack<>();
    public Integer getMin(){
        if (minStack.isEmpty()){
            return null;
        }
        return minStack.peek();
    }
    public Integer getMax(){
        if (maxStack.isEmpty()){
            return null;
        }
        return maxStack.peek();
    }
    public Integer pop(){
        if (stack.isEmpty()){
            return null;
        }
        Integer pop = stack.pop();
        if (minStack.peek() == pop) {
            minStack.pop();
        }
        if (maxStack.peek() == pop) {
            maxStack.pop();
        }
        return stack.pop();
    }
    public int push(int i){
        if (minStack.isEmpty() || i<= minStack.peek()) {
            minStack.push(i);
        }
        if (maxStack.isEmpty() || i >= maxStack.peek()) {
            maxStack.push(i);
        }
        return stack.push(i);
    }

    public static void main(String[] args) {
    }
}
