package com.wjc.lc.twenty.five.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description
 * @Date 2020/5/30 0030 下午 17:14
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] keyInts = new int[length];
        int[] valueInts = new int[length];
        int temp = nums[0];
        keyInts[0] = nums[0];
        valueInts[0] = 1;
        int count = 1;
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] == temp) {
                count++;
                valueInts[index] = count;
            } else {
                index++;
                temp = nums[i];
                count = 1;
                keyInts[index] = nums[i];
                valueInts[index] = 1;
            }
        }
        for (int i = 0; i < index + 1; i++) {
            for (int j = i; j < index + 1; j++) {
                if (valueInts[i]>valueInts[j]){
                    valueInts[i]=valueInts[i]+valueInts[j];
                    valueInts[j]=valueInts[i]-valueInts[j];
                    valueInts[i]=valueInts[i]-valueInts[j];
                    keyInts[i]=keyInts[i]+keyInts[j];
                    keyInts[j]=keyInts[i]-keyInts[j];
                    keyInts[i]=keyInts[i]-keyInts[j];
                }
            }
        }
        System.out.println(Arrays.toString(keyInts));
        System.out.println(Arrays.toString(valueInts));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = keyInts[index-i];
        }
        return res;
    }
}

public class 前K个高频元素 {
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
            line = in.readLine();
            int k = Integer.parseInt(line);

            int[] ret = new Solution().topKFrequent(nums, k);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}