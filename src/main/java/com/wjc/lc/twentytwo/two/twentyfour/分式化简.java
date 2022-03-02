package com.wjc.lc.twentytwo.two.twentyfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode-cn.com/problems/deep-dark-fraction/
 */
class Solution1 {
    public int[] fraction(int[] cont) {
        int[] res = {1, 1};
        int l = cont.length;
        res[0] = cont[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            int temp = res[0];
            res[0] = cont[i] * res[0] + res[1];
            res[1] = temp;
        }
        return res;
    }
}

public class 分式化简 {
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] cont = stringToIntegerArray(line);

            int[] ret = new Solution1().fraction(cont);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}