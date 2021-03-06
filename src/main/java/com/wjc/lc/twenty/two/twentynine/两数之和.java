package com.wjc.lc.twenty.two.twentynine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Description
 * @Date 2020/2/29 0029 下午 18:57
 * @Created by wjc
 *
 * 连接
 *  https://leetcode-cn.com/problems/two-sum/
 */

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (hashMap.containsKey(res)){
                return new int[]{hashMap.get(res),i};
            }
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("shit");

        //无脑暴力法
//        int[] res = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i]+nums[j]==target){
//                    res[0]=i;
//                    res[1]=j;
//                    break;
//                }
//            }
//        }
//        return res;
    }
}

public class 两数之和 {
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
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new Solution2().twoSum(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}