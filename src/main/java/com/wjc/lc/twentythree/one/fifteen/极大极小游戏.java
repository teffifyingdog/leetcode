package com.wjc.lc.twentythree.one.fifteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/min-max-game/
 */
class Solution {
    public int minMaxGame(int[] nums) {
        while (nums.length != 1) {
            nums = extracted(nums);
        }
        return nums[0];
    }

    private static int[] extracted(int[] nums) {
        int l = nums.length;
        int[] ints = new int[l/2];
        boolean flag = true;
        for (int i = 0; i < ints.length; i++) {
            if (flag) {
                ints[i] = Math.min(nums[i*2],nums[i*2+1]);
            }else {
                ints[i] = Math.max(nums[i*2],nums[i*2+1]);
            }
            flag = !flag;
        }
        return ints;
    }
}

public class 极大极小游戏 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().minMaxGame(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}