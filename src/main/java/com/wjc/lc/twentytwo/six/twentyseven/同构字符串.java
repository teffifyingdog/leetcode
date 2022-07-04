package com.wjc.lc.twentytwo.six.twentyseven;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/playground/new/empty/
 */
class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            int a = s.indexOf(s.charAt(i));
            int b = t.indexOf(t.charAt(i));
            System.out.println(a+","+b);
            if(a != b){
                return false;
            }
        }
        return true;
    }
}

public class 同构字符串 {
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
            line = in.readLine();
            String t = stringToString(line);

            boolean ret = new Solution1().isIsomorphic(s, t);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}