package com.wjc.lc.twentythree.one.twenty;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/finding-the-users-active-minutes/
 */
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int[] res = new int[k];
        for (int[] log : logs) {
            if (map.containsKey(log[0])) {
                HashSet<Integer> set = map.get(log[0]);
                set.add(log[1]);
            } else {
                map.put(log[0],new HashSet<Integer>(){{
                    add(log[1]);
                }});
            }
        }
        map.values().forEach(v->{
            res[v.size()-1]++;
        });
        return res;
    }
}

public class 查找用户活跃分钟数 {
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

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
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
            int[][] logs = stringToInt2dArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int[] ret = new Solution().findingUsersActiveMinutes(logs, k);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}