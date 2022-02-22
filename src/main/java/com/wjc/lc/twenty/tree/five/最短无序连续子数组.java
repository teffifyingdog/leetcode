package com.wjc.lc.twenty.tree.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/3/5 0005 下午 15:26
 * @Created by wjc
 * <p>
 * 连接
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */

class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag;
        for (int i = 1; i < length; i++) {
            flag = nums[i] < nums[i - 1];
            if (flag)
                min = Math.min(nums[i], min);
        }
        for (int i = length - 2; i >= 0; i--) {
            flag = nums[i] > nums[i + 1];
            if (flag)
                max = Math.max(nums[i], max);
        }
        int i, j;
        for (i = 0; i < length; i++) {
            if (nums[i] > min)
                break;
        }
        for (j = length - 1; j >= 0; j--) {
            if (nums[j] < max)
                break;
        }
//        System.out.println("min = " + min);
//        System.out.println("max = " + max);
//        System.out.println("i = " + i);
//        System.out.println("j = " + j);
        return j < 1 ? 0 : j - i + 1;


//        int[] temp = nums.clone();
//        Arrays.sort(temp);
//        System.out.println(Arrays.toString(temp));
//        System.out.println(Arrays.toString(nums));
//        int res = 0;
//        for (int i = 0; i < temp.length; i++) {
//            if (temp[i] == nums[i]) {
//                res++;
//            } else {
//                break;
//            }
//        }
//        for (int i = temp.length - 1; i >= 0; i--) {
//            if (temp[i] == nums[i]) {
//                res++;
//            } else {
//                break;
//            }
//        }
//        if (res / 2 >= nums.length)
//            return 0;
//        else
//            return nums.length - res;
    }
}

public class 最短无序连续子数组 {
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

            int ret = new Solution2().findUnsortedSubarray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}