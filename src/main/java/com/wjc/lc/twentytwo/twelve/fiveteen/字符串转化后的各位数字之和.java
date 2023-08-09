package com.wjc.lc.twentytwo.twelve.fiveteen;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/
 */
class Solution {
    public int getLucky(String s, int k) {
        char[] chars = s.toCharArray();
        String res = "";
        for (char aChar : chars) {
            int i = aChar - 96;
            res += i;
        }
        for (int i = 0; i < k; i++) {
            char[] array = res.toCharArray();
            int temp = 0;
            for (char c : array) {
                int j = c - 48;
                temp +=j;
            }
            res = temp+"";
        }

        return Integer.parseInt(res);
    }

    public static void main(String[] args) {
        Integer integer = Integer.valueOf("13154235234523455");
        System.out.println(integer);
    }
}

public class 字符串转化后的各位数字之和 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new Solution().getLucky(s, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}