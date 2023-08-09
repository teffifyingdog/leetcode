package com.wjc.lc.twentythree.two.five;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *https://leetcode.cn/problems/decode-the-message/
 */
class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(' ',' ');
        int i = 97;
        for (char c : key.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, (char) (i));
                i++;
            }
        }
        String res = "";
        for (char c : message.toCharArray()) {
            res += map.get(c);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((char) 97);
    }
}

public class 解密消息 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String key = stringToString(line);
            line = in.readLine();
            String message = stringToString(line);

            String ret = new Solution().decodeMessage(key, message);

            String out = (ret);

            System.out.print(out);
        }
    }
}