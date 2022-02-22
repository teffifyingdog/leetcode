package com.wjc.lc.twenty.four.sixteen;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description
 * @Date 2020/4/16 0016 下午 17:03
 * @Created by wjc
 */

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int length = intervals.length;
        int[][] res = new int[length][2];
        int count = -1;
        for (int[] interval : intervals) {
            if (count == -1 || interval[0] > res[count][1])
                res[++count] = interval;
            else
                res[count][1] = interval[1];
        }
        return Arrays.copyOf(res,count+1);
    }
}

public class 合并区间 {
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
        JSONArray jsonArray = JSONArray.parseArray(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JSONArray cols = (JSONArray) jsonArray.get(i);
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append(Arrays.toString(item));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] intervals = stringToInt2dArray(line);

            int[][] ret = new Solution().merge(intervals);

            String out = int2dArrayToString(ret);

            System.out.print(out);
        }
    }
}