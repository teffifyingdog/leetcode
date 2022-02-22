package com.wjc.lc.twenty.tree.sixteen;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Description
 * @Date 2020/3/16 0016 下午 14:25
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/compress-string-lcci/
 */

class Solution {
    public String compressString(String S) {

        int i = 0;
        StringBuilder builder = new StringBuilder();
        int length = S.length();

        while (i < length) {
            int j = i;
            while (j < length && S.charAt(i) == S.charAt(j)) {
                j++;
            }
            builder.append(S.charAt(i)).append(j - i);
            i = j;
        }
        if (builder.toString().length() == S.length())
            return S;
        else
            return builder.toString();
    }
}

public class 字符串压缩 {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = stringToString(line);

            String ret = new Solution().compressString(S);

            String out = (ret);

            System.out.print(out);
        }
    }
}