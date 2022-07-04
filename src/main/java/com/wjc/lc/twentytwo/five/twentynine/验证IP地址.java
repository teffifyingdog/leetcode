package com.wjc.lc.twentytwo.five.twentynine;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/validate-ip-address/
 */
class Solution {
    public String validIPAddress(String queryIP) {
return "";
    }
}

public class 验证IP地址 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(8/10);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String queryIP = stringToString(line);

            String ret = new Solution().validIPAddress(queryIP);

            String out = (ret);

            System.out.print(out);
        }
    }
}