package com.wjc.lc.twentythree.two.nineteen;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/maximum-average-pass-ratio/
 * [3, 11]
 * [4, 10]
 * [4, 6]
 * [4, 5]
 */
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            long v1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long v2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (v1 == v2)
                return 0;
            return v2 > v1 ? 1 : -1;
        });
        for (int[] ints : classes) {
            queue.offer(new int[]{ints[0], ints[1]});
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] ints = queue.poll();
            queue.offer(new int[]{ints[0] + 1, ints[1] + 1});
        }
        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] ints = queue.poll();
            res +=1.0 * ints[0] / ints[1];
        }
        return res / classes.length;
    }

    public static void main(String[] args) {
        int i = 0;
        Date a = null;
        assert a != null:"????";
        System.out.println(a.toString());
    }

//    public double maxAverageRatio(int[][] classes, int extraStudents) {
//        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
//            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
//            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
//            if (val1 == val2) {
//                return 0;
//            }
//            return val1 < val2 ? 1 : -1;
//        });
//        for (int[] c : classes) {
//            pq.offer(new int[]{c[0], c[1]});
//        }
//
//        for (int i = 0; i < extraStudents; i++) {
//            int[] arr = pq.poll();
//            int pass = arr[0], total = arr[1];
//            pq.offer(new int[]{pass + 1, total + 1});
//        }
//
//        double res = 0;
//        for (int i = 0; i < classes.length; i++) {
//            int[] arr = pq.poll();
//            System.out.println(Arrays.toString(arr));
//            int pass = arr[0], total = arr[1];
//            res += 1.0 * pass / total;
//        }
//        return res / classes.length;
//    }
}

public class 最大平均通过率 {
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

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] classes = stringToInt2dArray(line);
            line = in.readLine();
            int extraStudents = Integer.parseInt(line);

            double ret = new Solution().maxAverageRatio(classes, extraStudents);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}