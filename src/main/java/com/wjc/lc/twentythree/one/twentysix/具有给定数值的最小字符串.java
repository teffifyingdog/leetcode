package com.wjc.lc.twentythree.one.twentysix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/smallest-string-with-a-given-numeric-value/
 */
class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int max = Math.max(1, k - (n - i) * 26);
            k -= max;
            res.append((char) ('a' + max - 1));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
    }
}

public class 具有给定数值的最小字符串 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            String ret = new Solution().getSmallestString(n, k);

            String out = (ret);

            System.out.print(out);
        }
    }
}