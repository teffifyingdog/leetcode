package com.wjc.lc.twentytwo.three.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];
        for(int i = 0,j = l - 1,index = l - 1;i <= j;){
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if(a < b){
                res[index]=b;
                j--;
            }else{
                res[index]=a;
                i++;
            }
            index--;
        }
        return res;
    }
}

public class 有序数组的平方 {
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
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

            int[] ret = new Solution().sortedSquares(nums);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}