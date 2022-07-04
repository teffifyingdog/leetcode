package com.wjc.lc.twentytwo.six.twentyseven;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/is-subsequence/
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int t1 = 0, t2 = 0;
        while (t2 < t.length() && t1 < s.length()) {
            if (s.charAt(t1) == t.charAt(t2)) {
                t1++;
                t2++;
            } else {
                t2++;
            }
        }
        return t1 == s.length();
    }
}

public class 判断子序列 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String t = stringToString(line);

            boolean ret = new Solution().isSubsequence(s, t);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}