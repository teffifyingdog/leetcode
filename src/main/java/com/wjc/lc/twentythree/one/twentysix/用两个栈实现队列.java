package com.wjc.lc.twentythree.one.twentysix;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bmrlg0i
 */
public class 用两个栈实现队列 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.toString());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.toString());
    }
}
class CQueue {
    List<Integer> list;

    public CQueue() {
        list = new LinkedList<>();
    }

    public void appendTail(int value) {
        list.add(value);
    }

    public int deleteHead() {
        if (list.size() == 0) {
            return -1;
        }
        return list.remove(0);
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */