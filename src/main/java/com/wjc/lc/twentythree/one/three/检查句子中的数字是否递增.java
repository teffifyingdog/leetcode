package com.wjc.lc.twentythree.one.three;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 */
class Solution {
    public boolean areNumbersAscending(String s) {
        int temp = -1;
        int l = s.length();
        int start = 0;
        while (start < l) {
            if (Character.isDigit(s.charAt(start))) {
                int num = 0;
                while (start < l && Character.isDigit(s.charAt(start))) {
                    num = num * 10 + s.charAt(start) - '0';
                    start++;
                }
                if (num <= temp) {
                    return false;
                } else {
                    temp = num;
                }
                start++;
            }else {
                start++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int) '9');
    }
}

public class 检查句子中的数字是否递增 {
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

            boolean ret = new Solution().areNumbersAscending(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}