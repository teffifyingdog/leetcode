package com.wjc.lc.twentythree.six.twentynine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75">...</a>
 */
class Solution {
    public int maxOperations(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer integer = map.get(num);
            if (integer > 0) {
                map.put(num, --integer);
                Integer v = map.get(k - num);
                if (v != null && v > 0) {
                    map.put(k - num, --v);
                    res++;
                }
            }
        }
        return res;
    }
}

public class K和数对的最大数目 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new Solution().maxOperations(nums, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}