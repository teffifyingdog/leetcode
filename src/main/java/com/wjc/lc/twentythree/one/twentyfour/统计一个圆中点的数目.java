package com.wjc.lc.twentythree.one.twentyfour;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/queries-on-number-of-points-inside-a-circle/
 */
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ints = new int[queries.length];
        for (int i = 0;i< queries.length;i++) {
            ints[i] = isInQuery(points,queries[i]);
        }
        return ints;
    }

    private int isInQuery(int[][] points, int[] query) {
        int i = 0;
        int l = query[2] * query[2];
        for (int[] point : points) {
            int a = point[0] - query[0];
            int b = point[1] - query[1];
            if (a * a + b * b <= l) {
                i++;
            }
        }
        return i;
    }
}

public class 统计一个圆中点的数目 {
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
            int[][] points = stringToInt2dArray(line);
            line = in.readLine();
            int[][] queries = stringToInt2dArray(line);

            int[] ret = new Solution().countPoints(points, queries);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}