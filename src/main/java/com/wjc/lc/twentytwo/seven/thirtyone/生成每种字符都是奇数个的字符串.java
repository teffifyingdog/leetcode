package com.wjc.lc.twentytwo.seven.thirtyone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
 */
class Solution {
    public String generateTheString(int n) {
        if (n <= 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        } else {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}

public class 生成每种字符都是奇数个的字符串 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            String ret = new Solution().generateTheString(n);

            String out = (ret);

            System.out.print(out);
        }
    }
}