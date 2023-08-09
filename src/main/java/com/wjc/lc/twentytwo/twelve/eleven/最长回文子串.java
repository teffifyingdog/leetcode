package com.wjc.lc.twentytwo.twelve.eleven;


import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int end = 0;
        int start = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (map.containsKey(c)) {
                if (i - map.get(c) > max) {
                    max = i - map.get(c);
                    start = map.get(c);
                    end = i;
                }
            }else {
                map.put(c,i);
            }
        }
        return s.substring(start,end+1);
    }
}

public class 最长回文子串 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = new Solution().longestPalindrome(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}