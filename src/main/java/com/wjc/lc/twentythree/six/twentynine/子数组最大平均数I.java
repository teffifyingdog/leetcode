package com.wjc.lc.twentythree.six.twentynine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * <a href="https://leetcode.cn/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75">...</a>
 */
class Solution1 {
    public double findMaxAverage(int[] nums, int k) {
        int l = 1, r = k;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        double ave = sum / k;
        while (r < nums.length) {
            sum = sum - nums[l - 1] + nums[r];
            ave = Math.max(ave,sum / k);
            l++;
            r++;
        }
        return ave;
    }
}

public class 子数组最大平均数I {
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

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            double ret = new Solution1().findMaxAverage(nums, k);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}