package com.wjc.lc.twentythree.six.thirteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 28600
 * <a href="https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75">...</a>
 */

public class 拥有最多糖果的孩子 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().orElse(0);
        ArrayList<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            list.add(candies[i] + extraCandies >= max);
        }
        return list;
    }
}