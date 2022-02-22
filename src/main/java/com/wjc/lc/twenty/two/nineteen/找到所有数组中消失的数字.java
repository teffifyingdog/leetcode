package com.wjc.lc.twenty.two.nineteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    链接
    https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */

class Solution2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])-1] > 0) {
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
        //也可以，但是很丢人
//        if (nums.length == 0){
//            return new ArrayList<>();
//        }
//        Arrays.sort(nums);
//        ArrayList<Integer> list = new ArrayList<>();
//        int number = 1;
//        int count = 0;
//        while (number < nums.length){
//            if (count>nums.length-1){
//                while (number < nums.length){
//                    number++;
//                    list.add(number);
//                }
//                break;
//            }
//
//            if (number < nums[0]){
//                list.add(number);
//                number++;
//            }else if (nums[count] == number){
//                count++;
//            }else if (nums[count] == number +1){
//                number++;
//                count++;
//            } else {
//                number++;
//                list.add(number);
//            }
//
//        }
//        return list;
    }
}

public class 找到所有数组中消失的数字 {
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<Integer> ret = new Solution2().findDisappearedNumbers(nums);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}