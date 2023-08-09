package com.wjc.lc.twentythree.two.twentyfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/
 */
class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int min = getMin(nums);
        int res = 0;
        while (min != 0){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] = nums[i] - min;
                }
            }
            min = getMin(nums);
            res++;
        }
        return res;
    }

    private int getMin(int[] nums) {
        for (int num : nums) {
            if (num != 0)
                return num;
        }
        return 0;
    }
}

public class 使数组中所有元素都等于零 {
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

            int ret = new Solution().minimumOperations(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}