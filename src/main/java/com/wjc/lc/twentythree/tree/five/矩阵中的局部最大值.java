package com.wjc.lc.twentythree.tree.five;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 */
class Solution1 {
    public int[][] largestLocal(int[][] grid) {
        int l = grid.length;
        int[][] res = new int[l - 2][l - 2];
        for (int x = 1; x < l - 1; x++) {
            for (int y = 1; y < l - 1; y++) {
                res[x - 1][y - 1] = getMax(grid, x, y);
            }
        }
        return res;
    }

    private int getMax(int[][] grid, int x, int y) {
        int[] ints = {grid[x - 1][y - 1], grid[x - 1][y], grid[x - 1][y + 1],
                grid[x][y - 1], grid[x][y], grid[x][y + 1],
                grid[x + 1][y - 1], grid[x + 1][y], grid[x + 1][y + 1]};
        Arrays.sort(ints);
        return ints[8];
    }
}

public class 矩阵中的局部最大值 {
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
            int[][] grid = stringToInt2dArray(line);

            int[][] ret = new Solution1().largestLocal(grid);

            String out = int2dArrayToString(ret);

            System.out.print(out);
        }
    }
}