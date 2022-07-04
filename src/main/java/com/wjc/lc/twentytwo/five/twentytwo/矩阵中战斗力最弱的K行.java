package com.wjc.lc.twentytwo.five.twentytwo;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/the-k-weakest-rows-in-a-matrix/
 */
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int length = mat.length;
        int ll = mat[0].length;
        int[][] temp = new int[length][2];
        for (int i = 0; i < length; i++) {
            int[] ints = mat[i];
            int l = 0, r = ll - 1, t = -1;
            while (l <= r){
                int mid =  (l+r)/2;
                System.out.println(l+","+r+"mid = " + mid);
                if (ints[mid] == 1) {
                    t = mid;
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            temp[i] = new int[]{t+1,i};
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }else {
                    return a[1] - b[1];
                }
            }
        });
        for (int[] ints : temp) {
            queue.offer(ints);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[1];
        }
        return res;
    }
}

public class 矩阵中战斗力最弱的K行 {
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
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
            int[][] mat = stringToInt2dArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int[] ret = new Solution().kWeakestRows(mat, k);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
//[[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]]