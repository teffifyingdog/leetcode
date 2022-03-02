package com.wjc.lc.twentytwo.two.twentyfive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(list);
        for (int i = 1; i < nums.length; i++) {
            lists = addList(lists,nums[i]);
        }
        return lists;
    }
    private List<List<Integer>> addList(List<List<Integer>> lists,int a){
        LinkedList<List<Integer>> res = new LinkedList<>();
        int size = lists.size();
        for (int i = 0; i < size; i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j <= list.size(); j++) {
                LinkedList<Integer> l = new LinkedList<>(list);
                l.add(j,a);
                res.add(l);
            }
        }
        return res;
    }
}

public class 全排列 {
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Solution().permute(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}