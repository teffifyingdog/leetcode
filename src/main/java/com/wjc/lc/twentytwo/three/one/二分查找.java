package com.wjc.lc.twentytwo.three.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode-cn.com/problems/binary-search/
 */
class Solution {
    public int search(int[] nums, int target) {
//        return s(nums, 0, nums.length - 1, target);
        int start = 0, end = nums.length - 1;
        while (end >= start) {
            int mid = (start + end) / 2;
            int num = nums[mid];
            if (num > target){
                end = mid - 1;
            }else if (num == target){
                return mid;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

    int s(int[] nums, int start, int end, int target) {
        if (end <= start && target != nums[end]) {
            return -1;
        }
        int mid = (end + start) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (target < nums[mid]) {
            return s(nums, start, mid, target);
        } else {
            return s(nums, mid + 1, end, target);
        }
    }
}

public class 二分查找 {
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
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new Solution().search(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}