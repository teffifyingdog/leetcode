package com.wjc.lc.twenty.seven.eigth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @Description
 * @Date 2020/7/8 0008 下午 16:13
 * @Created by wjc
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            System.out.println("slow = " + slow+","+fast);
        } while (slow != fast);
//        slow = 0;
//        while (slow != fast) {
//            slow = nums[slow];
//            fast = nums[fast];
//        }
        return nums[slow];
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            boolean flag = hashSet.add(nums[i]);
//            if (!flag)
//                return nums[i];
//        }
//        return 0;
    }
}

public class 寻找重复数 {
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

            int ret = new Solution().findDuplicate(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}