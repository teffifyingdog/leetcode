package com.wjc.lc.twenty.tree.twentyfive;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/3/25 0025 下午 19:12
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 */

class Solution {
    public int surfaceArea(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    count += grid[i][j] * 4 + 2;
                    if (i == 0 && j > 0) {
                        count -= Math.min(grid[0][j - 1], grid[0][j]) * 2;
                    }
                    if (j == 0 && i > 0) {
                        count -= Math.min(grid[i][0], grid[i - 1][0]) * 2;
                    }
                    if (i > 0 && j > 0) {
                        count -= Math.min(grid[i - 1][j], grid[i][j]) * 2;
                        count -= Math.min(grid[i][j - 1], grid[i][j]) * 2;
                    }
                }
            }
        }
        return count;
    }
}

public class 三维形体的表面积 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] grid = stringToInt2dArray(line);

            int ret = new Solution().surfaceArea(grid);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}