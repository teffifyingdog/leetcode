package com.wjc.lc.twentytwo.six.thirty;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/longest-palindrome/
 */
class Solution {
    public int longestPalindrome(String s) {
        int[] cs = new int[128];
        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i)]++;
        }
        int count = 0;
        for (int i : cs) {
            count += i % 2;
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}

public class 最长回文串 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().longestPalindrome(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}