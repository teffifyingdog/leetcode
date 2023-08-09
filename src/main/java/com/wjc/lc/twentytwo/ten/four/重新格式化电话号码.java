package com.wjc.lc.twentytwo.ten.four;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 28600
 * https://leetcode.cn/problems/reformat-phone-number/
 */
class Solution {
    public String reformatNumber(String number) {
        String replace = number.replace(" ", "").replace("-", "");
        int length = replace.length();
        System.out.println("length = " + length);
        String res = "";
        int t = 0;
        while (t < length) {
            if ((length - t) > 4){
                res =res + replace.substring(t,t+3) + "-";
                t =t+3;
                System.out.println("t = " + t);
            }else if ((length - t) == 4){
                res = res + replace.substring(t,t+2) + "-" +replace.substring(t+2,t+4);
                break;
            }else if ((length - t) < 4){
                res = res + replace.substring(t,length);
                break;
            }

        }
        return res;
    }
}

public class 重新格式化电话号码 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String number = stringToString(line);

            String ret = new Solution().reformatNumber(number);

            String out = (ret);

            System.out.print(out);
        }
    }
}