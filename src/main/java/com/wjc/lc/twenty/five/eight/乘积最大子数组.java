package com.wjc.lc.twenty.five.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * @Description
 * @Date 2020/5/18 0018 下午 17:22
 * @Created by wjc
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        int preMax = nums[0];
        int preMin = nums[0];
        int res = nums[0];

        int curMax;
        int curMin;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num >= 0) {
                curMax = Math.max(preMax * num, num);
                curMin = Math.min(preMin * num, num);
            } else {
                curMax = Math.max(preMin * num, num);
                curMin = Math.min(preMax * num, num);
            }
            res = Math.max(res, curMax);
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }

//    int max = Integer.MIN_VALUE;
//    public int maxProduct(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            getMax(Arrays.copyOf(nums,i));
//        }
//        getMax(nums);
//        return max;
//    }
//
//    /**
//     * @description
//     * @date 2020/5/18 0018
//     */
//    public void getMax(int[] nums) {
//        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
//        if (nums.length==1) {
//            max = Math.max(nums[0], max);
//            return;
//        }
//        if (nums.length==2) {
//            max = Math.max(Math.max(max,nums[1]),nums[0]*nums[1]);
//            return;
//        }
//        max=Math.max(max,nums[nums.length-1]);
//        int sum = nums[nums.length-2]*nums[nums.length - 1];
//        if (max < sum) {
//            max = sum;
//        }
//
//        for (int i = nums.length - 3; i >= 0; i--) {
//            sum = nums[i] * sum;
//            if (max < sum) {
//                max = sum;
//            }
//        }
//
//    }
}

public class 乘积最大子数组 {
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

            int ret = new Solution().maxProduct(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] i = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(Arrays.copyOf(i, 2)));
    }
}