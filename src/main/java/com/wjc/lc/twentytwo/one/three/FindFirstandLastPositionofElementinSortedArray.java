package com.wjc.lc.twentytwo.one.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    //    public int[] searchRange(int[] nums, int target) {
//        int l = nums.length;
//        int min = -1;
//        int max = -1;
//        for (int i = 0; i < l; i++) {
//            if (nums[i] == target && min == -1) {
//                min = i;
//            }
//            if (nums[l - 1 - i] == target && max == -1) {
//                max = l - 1 - i;
//            }
//            if (min !=-1 && max != -1){
//                break;
//            }
//        }
//        return new int[]{min, max};
//    }
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = twoSplit(nums, target, true);
        int rightIdx = twoSplit(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int twoSplit(int[] nums, int target, boolean isLeft) {
        int res = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] > target || (isLeft && nums[mid] >= target)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}


public class FindFirstandLastPositionofElementinSortedArray {
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
            int target = Integer.parseInt(line);

            int[] ret = new Solution().searchRange(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}