package com.wjc.lc.twentythree.one.twentyseven;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/
 */
class Solution {
    public String greatestLetter(String s) {

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (int i = 122; i >= 97; i--) {
            if (set.contains((char)(i)) && set.contains((char)(i-32))){
                return (char)(i-32)+"";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println((int) 'A');
    }
}

public class 兼具大小写的最好英文字母 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = new Solution().greatestLetter(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}