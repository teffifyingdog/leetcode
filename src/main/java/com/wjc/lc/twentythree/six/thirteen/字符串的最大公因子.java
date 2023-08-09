package com.wjc.lc.twentythree.six.thirteen;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://leetcode.cn/problems/greatest-common-divisor-of-strings/">...</a>
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        int t = a % b;
        while (t != 0) {
            a = b;
            b = t;
            t = a % b;
        }
        return b;
    }
}

/**
 * @author 28600
 */
public class 字符串的最大公因子 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String str1 = stringToString(line);
            line = in.readLine();
            String str2 = stringToString(line);

            String ret = new Solution().gcdOfStrings(str1, str2);

            String out = (ret);

            System.out.print(out);
        }
    }
}