package com.wjc.lc.twentythree.five.twentysix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/o8SXZn/
 */
class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int l = Math.min(vat.length, bucket.length);
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < l; i++) {
            int num = getNum(vat[i], bucket[i]);
            if (num > max) {
                max = num;
                index = i;
            }
        }
        if (index > -1) {
            int temp = bucket[index];
            int min = getNum(vat[index], bucket[index]);
            while (vat[index] >= temp) {
                temp++;
                int num = getNum(vat[index], temp) + (temp - bucket[index]);
                min = Math.min(min, num);
            }
            return min;
        }
        return 0;
    }

    public int getNum(int v, int b) {
        if (v == 0) {
            return 0;
        }
        if (b >= v) {
            return 1;
        }
        if (b == 0) {
            return v + 1;
        }
        return v / b + (v % b > 0 ? 1 : 0);
    }
}

public class 蓄水 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] bucket = stringToIntegerArray(line);
            line = in.readLine();
            int[] vat = stringToIntegerArray(line);

            int ret = new Solution().storeWater(bucket, vat);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}