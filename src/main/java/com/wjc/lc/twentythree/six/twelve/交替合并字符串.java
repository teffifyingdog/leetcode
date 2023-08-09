package com.wjc.lc.twentythree.six.twelve;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://leetcode.cn/problems/merge-strings-alternately/">...</a>
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        int min = Math.min(w1, w2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        sb.append(word1, min, w1).append(word2, min, w2);
        return sb.toString();
    }
}

/**
 * @author 28600
 */
public class 交替合并字符串 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String word1 = stringToString(line);
            line = in.readLine();
            String word2 = stringToString(line);

            String ret = new Solution().mergeAlternately(word1, word2);

            String out = (ret);

            System.out.print(out);
        }
    }
}