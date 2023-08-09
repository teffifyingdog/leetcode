package com.wjc.lc.twentytwo.twelve.eleven;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution1 {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if (l <2) {
            return l;
        }
        int s = 0;
        int e = 1;
        while (l > e){
            if (nums[s] != nums[e]) {
                nums[s+1] = nums[e];
                s++;
                e++;
            }else {
                e++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return s+1;
    }
}

public class 删除有序数组中的重复项 {
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

            int ret = new Solution1().removeDuplicates(nums);
            String out = integerArrayToString(nums, ret);

            System.out.print(out);
        }
    }
}