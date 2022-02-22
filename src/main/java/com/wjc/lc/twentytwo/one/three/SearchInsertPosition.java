package com.wjc.lc.twentytwo.one.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution1 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;
        while (right >= left) {
            int mid = (right + left) >> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

public class SearchInsertPosition {
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

            int ret = new Solution1().searchInsert(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}