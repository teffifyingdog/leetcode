package com.wjc.lc.twenty.two.twentynine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/2/29 0029 下午 18:22
 * @Created by wjc
 *
 * 连接
 *  https://leetcode-cn.com/problems/climbing-stairs/
 */

class Solution {
    public int climbStairs(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }
}

public class 爬楼梯 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().climbStairs(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}