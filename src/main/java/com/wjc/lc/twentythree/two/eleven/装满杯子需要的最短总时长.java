package com.wjc.lc.twentythree.two.eleven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
 */
class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int a = amount[0];
        int b = amount[1];
        int c = amount[2];
        if (a+b>=c){
            return (a+b+c+1)/2;
        }else {
            return c;
        }
    }
}

public class 装满杯子需要的最短总时长 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] amount = stringToIntegerArray(line);

            int ret = new Solution().fillCups(amount);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}