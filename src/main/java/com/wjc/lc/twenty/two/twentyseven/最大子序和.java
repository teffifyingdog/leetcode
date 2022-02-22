package com.wjc.lc.twenty.two.twentyseven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(nums[i],temp+nums[i]);
            max = Math.max(max,temp);
        }
        return max;
    }
}

public class 最大子序和 {
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

            int ret = new Solution().maxSubArray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}