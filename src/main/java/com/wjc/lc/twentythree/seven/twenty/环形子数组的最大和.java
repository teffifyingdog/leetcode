package com.wjc.lc.twentythree.seven.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-circular-subarray/">...</a>
 */
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int pmax = nums[0], maxRes = nums[0], pmin = nums[0], minRes = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pmax = Math.max(pmax + nums[i], nums[i]);
            maxRes = Math.max(maxRes, pmax);
            pmin = Math.min(pmin + nums[i], nums[i]);
            minRes = Math.min(minRes, pmin);
            sum += nums[i];
        }
        if (maxRes < 0) {
            return maxRes;
        } else {
            return Math.max(maxRes, sum - minRes);
        }
    }
}

/**
 * @author 28600
 */
public class 环形子数组的最大和 {
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

            int ret = new Solution().maxSubarraySumCircular(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}