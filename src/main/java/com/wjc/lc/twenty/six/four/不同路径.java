package com.wjc.lc.twenty.six.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/6/4 0004 下午 14:30
 * @Created by wjc
 */
class Solution {
    //    public int uniquePaths(int m, int n) {
//        if (m==1||n==1)
//            return 1;
//        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
//    }
    public int uniquePaths(int m, int n) {
        int a = m + n - 2;
        int b = m - 1;
        //用int会有偏差
        long res = 1;
        for (int i = 1; i <= b; i++) {
            res = res * (a - b + i) / i;
        }
        return (int)res;
    }
}

public class 不同路径 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            int ret = new Solution().uniquePaths(m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}