package com.wjc.lc.twenty.tree.twentythree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/3/23 0023 下午 13:46
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */

class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = res[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i = length -1; i >= 0; i--) {
            res[i] = right*res[i];
            right *=nums[i];
        }
        return res;


//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int temp = 1;
//            for (int j = 0; j < nums.length; j++) {
//                if (i!=j)
//                    temp *= nums[j];
//            }
//            res[i] = temp;
//        }
//        return res;
    }
}

public class 除自身以外数组的乘积 {
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
            int[] nums = stringToIntegerArray(line);

            int[] ret = new Solution2().productExceptSelf(nums);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}