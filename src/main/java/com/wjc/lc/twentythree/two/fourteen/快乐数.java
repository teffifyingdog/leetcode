package com.wjc.lc.twentythree.two.fourteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/happy-number/
 */
class Solution1 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)){
            if (n == 1){
                return true;
            }
            set.add(n);
            n = a(n);
        }
        return false;
    }

    public int a(int x) {
        int res = 0;
        while (x > 0) {
            int a = x % 10;
            res += a * a;
            x = x/10;
        }
        return res;
    }
}

public class 快乐数 {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            boolean ret = new Solution1().isHappy(n);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}