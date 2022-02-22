package com.wjc.lc.twentyone.twelve.twentyeight;

import java.util.*;

public class SortString {
    public static void main(String[] args) {
        System.out.println(frequencySort("aaavvcccc"));
    }

    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }
        max = max + 1;
        StringBuffer[] sbs = new StringBuffer[max];
        for (int i = 0; i < max; i++) {
            sbs[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sbs[entry.getValue()].append(entry.getKey());
        }
        StringBuffer sb = new StringBuffer();
        for (int i = sbs.length-1; i > 0; i--) {
            for (int j = 0; j < sbs[i].length(); j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(sbs[i].charAt(j));
                }
            }
        }
        return sb.toString();
    }

    public static String isDuiCheng(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Character> keySet = map.keySet();
        ArrayList<Character> list = new ArrayList<>(keySet);
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        for (Character c : list) {
            for (Integer i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
