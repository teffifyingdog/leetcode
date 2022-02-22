package com.wjc.lc.twenty.two.fifteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    题目链接
    https://leetcode-cn.com/problems/hamming-distance/


 */
class Solution2 {
    public int hammingDistance(int x, int y) {
        System.out.println("x^y = " + (x ^ y));
        return Integer.bitCount(x^y);
    }
}

public class 汉明距离 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            line = in.readLine();
            int y = Integer.parseInt(line);

            int ret = new Solution2().hammingDistance(x, y);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}