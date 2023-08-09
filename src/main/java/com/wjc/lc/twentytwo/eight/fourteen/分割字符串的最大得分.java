package com.wjc.lc.twentytwo.eight.fourteen;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
 */
class Solution {
    public int maxScore(String s) {

        int temp = s.startsWith("0") ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                temp++;
            }
        }
        int max = temp;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0'){
                temp++;
            }else {
                temp--;
            }
            max = Math.max(max,temp);
        }
        return max;
    }
}

public class 分割字符串的最大得分 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().maxScore(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}