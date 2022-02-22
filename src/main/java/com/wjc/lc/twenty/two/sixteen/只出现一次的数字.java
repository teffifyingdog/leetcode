package com.wjc.lc.twenty.two.sixteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
    链接
    https://leetcode-cn.com/problems/single-number/
 */
class Solution3 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            boolean add = hashSet.add(num);
            if (add == false){
                hashSet.remove(num);
            }
        }
        return hashSet.iterator().next();
    }

    public int 标准答案12312213(int[] nums) {
        int ans = 0;
        for(int num: nums) {
            ans ^= num;
        }
        return ans;
    }
}

public class 只出现一次的数字 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
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

            int ret = new Solution3().singleNumber(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}