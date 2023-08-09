package com.wjc.lc.twentythree.two.seventeen;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/largest-1-bordered-square/
 */
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int x = grid[0].length;
        int y = grid.length;
        int r = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
               r =  Math.max(r,func(i,j,0,grid));
            }
        }
        return r*r;
    }

    private int func(int x, int y, int c, int[][] grid) {
        for (int i = x; i < x+c; i++) {

        }
        return 0;
    }
}

public class 最大的以1为边界的正方形 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] grid = stringToInt2dArray(line);

            int ret = new Solution().largest1BorderedSquare(grid);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}