package com.wjc.lc.twentytwo.two.twentyseven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode-cn.com/problems/optimal-division/
 */
class Solution1 {
    double max = 0;

    public String optimalDivision(int[] nums) {
        int l = nums.length;
        if (l<=1) {
            return String.valueOf(nums[0]);
        }
        if (l==2){
            return String.valueOf(nums[0]+"/"+nums[1]);
        }
        StringBuffer bf = new StringBuffer();
        bf.append(nums[0]);
        bf.append("/(");
        for (int i = 1; i < l-1; i++) {
            bf.append(nums[i]).append("/");
        }
        bf.append(nums[l-1]);
        bf.append(")");
        return bf.toString();
    }

    void od(int[] nums) {
        int l = nums.length;
        if (l == 2) {
            double temp = nums[0] / nums[1];
            max = Math.max(temp, max);
            return;
        }
        for (int i = 0; i < l; i++) {
            int[] ints = new int[l - 1];
            for (int j = 0, k = 0; k < ints.length; k++) {
                if (i == j) {
                    ints[k] = nums[j] / nums[j + 1];
                    j++;
                }else {
                    ints[k] = nums[j];
                }
                j++;
            }
            od(ints);
        }
    }
}

public class 最优除法 {
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

            String ret = new Solution1().optimalDivision(nums);

            String out = (ret);

            System.out.print(out);
        }
    }
}