package com.wjc.lc.twenty.tree.seventeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2020/3/17 0017 下午 16:27
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/combination-sum/
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> arrayList = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        int sum = target;
        test(sum, arrayList, lists, candidates,0);
        return lists;
    }

    private void test(int sum, LinkedList<Integer> arrayList, List<List<Integer>> lists, int[] candidates, int begin) {
        if (sum == 0) {
            lists.add(new ArrayList<>(arrayList));
            return;
        }
        if (sum < 0)
            return;
        for (int i = begin; i < candidates.length; i++) {
            arrayList.add(candidates[i]);
            test(sum - candidates[i],arrayList,lists,candidates, i);
            arrayList.removeLast();
        }
    }

}

public class 组合总和 {
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

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
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
            int[] candidates = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            List<List<Integer>> ret = new Solution().combinationSum(candidates, target);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}