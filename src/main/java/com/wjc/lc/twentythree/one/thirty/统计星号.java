package com.wjc.lc.twentythree.one.thirty;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/count-asterisks/
 */
class Solution1 {
    public int countAsterisks(String s) {
        int i = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '|'){
                i++;
            }else if (c == '*' && i%2 == 0){
                res++;
            }
        }
        return res;
    }
}

public class 统计星号 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution1().countAsterisks(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}