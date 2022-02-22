package com.wjc.lc.twenty.six.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/6/6 0006 上午 6:57
 * @Created by wjc
 *
 * https://leetcode-cn.com/problems/perfect-squares/
 */

class Solution {
    public int numSquares(int n) {
        return  n;
    }
}

public class 完全平方数 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().numSquares(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}