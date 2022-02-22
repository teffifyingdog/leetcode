package com.wjc.lc.twenty.tree.twentyfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/3/24 0024 下午 13:05
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 */

class Solution {
    public int massage(int[] nums) {
        int curr = 0,pre = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = curr;
            curr = Math.max(curr,pre+nums[i]);
            pre = curr;
        }
        return curr;
    }

}

public class 按摩师 {
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

            int ret = new Solution().massage(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}