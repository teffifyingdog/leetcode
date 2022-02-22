package com.wjc.lc.twenty.tree.twentytwo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * @Description
 * @Date 2020/3/22 0022 下午 12:42
 * @Created by wjc
 *
 * https://leetcode-cn.com/problems/rotate-image/
 */

class Solution2 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] res = new int[length][length];
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length; i++) {
                res [j][i] = matrix[length-i-1][j];
                System.out.println("res[j][i] = " + res[j][i]);
            }
        }
        System.out.println(Arrays.toString(res[0])+","+Arrays.toString(res[1])+","+Arrays.toString(res[2]));
        for (int i = 0; i < length; i++) {
            matrix[i] = res[i];
        }
    }
}

public class 旋转图像 {
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
        JSONArray jsonArray = JSON.parseArray(input);
        if (jsonArray.size()== 0) {
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
            int[][] matrix = stringToInt2dArray(line);

            new Solution2().rotate(matrix);
            String out = int2dArrayToString(matrix);

            System.out.print(out);
        }
    }
}