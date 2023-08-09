package com.wjc.lc.twentythree.one.twentyone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/minimum-sideway-jumps/
 */
class Solution {
    public int minSideJumps(int[] obstacles) {
        return t(0,2,obstacles);
    }
    public int t(int x,int y,int[] obs){
        if (x+1 >= obs.length) {
            return 0;
        }
        if (obs[x+1] == y){
            return 1;
        }
        return 1;
    }
}

public class 最少侧跳次数 {
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
            int[] obstacles = stringToIntegerArray(line);

            int ret = new Solution().minSideJumps(obstacles);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}