package com.wjc.lc.twentythree.six.fiveteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 28600
 * <a href="https://leetcode.cn/problems/increasing-triplet-subsequence/">...</a>
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > second){
                return true;
            }else if (nums[i] > first){
                second = nums[i];
            }else {
                first = nums[i];
            }
        }
        return false;
    }
}

public class 递增的三元子序列 {
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            boolean ret = new Solution().increasingTriplet(nums);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}