package com.wjc.lc.twentythree.six.fourteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 28600
 * <a href="https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned/">...</a>
 */

class Solution1 {
    public int numTimesAllBlue(int[] flips) {
        int max = 0;
        int res = 0;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);
            if (i == max - 1){
                res++;
            }
        }
        return res;
    }
}

public class 二进制字符串前缀一致的次数 {
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
            int[] flips = stringToIntegerArray(line);

            int ret = new Solution1().numTimesAllBlue(flips);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}