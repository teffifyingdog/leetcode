package com.wjc.lc.twentytwo.two.twentytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if (l <=1) {
            return l;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        list.add(chars[0]);
        for (int i = 1; i < l; i++) {
            if (list.contains(chars[i])) {
                int index = list.indexOf(chars[i]);
                for (int j = 0; j <= index; j++) {
                    list.remove(0);
                }
                list.add(chars[i]);
            }else {
                list.add(chars[i]);
            }
            max = Math.max(max, list.size());
        }
        return max;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {

            int ret = new Solution().lengthOfLongestSubstring(line);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}