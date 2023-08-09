package com.wjc.lc.twentytwo.eight.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 */
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int sum = Arrays.stream(nums).sum();
        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = nums.length - 1;
        while (temp <= sum){
            temp += nums[i];
            sum -= nums[i];
            list.add(nums[i]);
            i--;
        }
        return list;
    }
}

public class 非递增顺序的最小子序列 {
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<Integer> ret = new Solution().minSubsequence(nums);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}