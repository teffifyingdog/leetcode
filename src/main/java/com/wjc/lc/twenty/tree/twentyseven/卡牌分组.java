package com.wjc.lc.twenty.tree.twentyseven;


import com.wjc.lc.twenty.two.sixteen.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Date 2020/3/27 0027 下午 19:35
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] ints = new int[10000];
        for (int i : deck) {
            ints[i]++;
        }
        int g = -1;
        for (int i = 0; i < 10000; i++) {
            if (ints[i]>0) {
                if (g == -1){
                    g = ints[i];
                }else {
                    g = gcd(g,ints[i]);
                }
            }
        }
        return g >= 2;
//        if (deck.length == 1){
//            return false;
//        }
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < deck.length; i++) {
//            int key = deck[i];
//            if (hashMap.containsKey(key)) {
//                int value = hashMap.get(key) + 1;
//                hashMap.put(key, value);
//            } else {
//                hashMap.put(key, 1);
//            }
//        }
//
//        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
//        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
//        Iterator<Map.Entry<Integer, Integer>> iterator1 = entrySet.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, Integer> next = iterator.next();
//            min = Math.min(next.getValue(),min);
//        }
//        while (iterator1.hasNext()) {
//            Map.Entry<Integer, Integer> next = iterator1.next();
//            if (next.getValue() % min != 0) {
//                return false;
//            }
//        }
//        return true;

    }

    private int gcd(int x, int y) {
        return x == 0 ? y :gcd(y%x,x);
    }
}

public class 卡牌分组 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] deck = stringToIntegerArray(line);

            boolean ret = new Solution().hasGroupsSizeX(deck);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}

class test {
    public static void main(String[] args) {
        System.out.println(3 % 6);
//        ListNode s1 = new ListNode(1);
//        ListNode s2 = new ListNode(1);
//        System.out.println("s1 = " + s1.hashCode());
//        System.out.println("s2 = " + s2.hashCode());
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
    }
}