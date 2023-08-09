package com.wjc.lc.twentythree.six.thirteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 28600
 * <a href="https://leetcode.cn/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75">...</a>
 */

class Solution1 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0 && (i + 1 == l || flowerbed[i + 1] == 0)) {
                n--;
                i++;
            } else if (flowerbed[i] == 1) {
                i++;
            }
        }
        return n <= 0;
    }
}

public class 种花问题 {
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] flowerbed = stringToIntegerArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            boolean ret = new Solution1().canPlaceFlowers(flowerbed, n);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}