package com.wjc.lc.twentytwo.eight.seventeen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/design-an-ordered-stream/
 */
public class 设计有序流 {
    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));

    }
}

class OrderedStream {
    Map<Integer, String> map;
    int ptr = 1;

    public OrderedStream(int n) {
        map = new HashMap<>(n);
    }

    public List<String> insert(int idKey, String value) {
        List<String> list = new ArrayList<>();
        map.put(idKey, value);
        int temp = ptr;
        while (map.get(temp) != null) {
            list.add(map.get(temp));
            temp++;
        }
        ptr = temp;
        return list;
    }
}