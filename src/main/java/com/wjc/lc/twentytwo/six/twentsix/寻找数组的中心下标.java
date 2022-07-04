package com.wjc.lc.twentytwo.six.twentsix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-pivot-index/
 */

class Solution1 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int total = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;

    }
}

public class 寻找数组的中心下标 {
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

            int ret = new Solution1().pivotIndex(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}