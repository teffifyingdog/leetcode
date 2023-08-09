package com.wjc.lc.twentythree.six.twentyseven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *<a href="https://leetcode.cn/problems/find-the-pivot-integer/">...</a>
 */
class Solution {
    public int pivotInteger(int n) {
        return 1;
    }
}

public class 找出中枢整数 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().pivotInteger(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}