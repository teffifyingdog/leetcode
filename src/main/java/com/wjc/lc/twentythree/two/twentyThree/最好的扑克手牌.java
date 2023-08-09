package com.wjc.lc.twentythree.two.twentyThree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/best-poker-hand/
 */
class 最好的扑克手牌 {
    public String bestHand(int[] ranks, char[] suits) {
        HashSet<Character> set = new HashSet<>();
        for (char suit : suits) {
            set.add(suit);
        }
        if (set.size() == 1) {
            return "Flush";
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            map.merge(rank,1,Integer::sum);
        }
        for (Integer value : map.values()) {
            if (value >= 3) {
                return "Three of a Kind";
            }
        }

        for (Integer value : map.values()) {
            if (value == 2) {
                return "Pair";
            }
        }
        return "High Card";
    }
}

