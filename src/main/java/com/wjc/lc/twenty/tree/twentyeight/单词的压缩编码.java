package com.wjc.lc.twenty.tree.twentyeight;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Description
 * @Date 2020/3/28 0028 上午 10:33
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 */

class Solution {
    public int minimumLengthEncoding(String[] words) {
        double count = 0;
        double jin = 0;
        for (int i = 0; i < words.length; i++) {
            count += words[i].length();
            jin++;
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].equals(words[j])) {
                    count -= words[j].length() / 2;
                    jin = jin - 0.5;
                } else if (i != j && words[i].endsWith(words[j])) {
                    count -= words[j].length();
                    jin--;
                }
            }
        }
        return (int) (count + jin);
    }
}

public class 单词的压缩编码 {
    public static String[] stringToStringArray(String input) {
        JSONArray jsonArray = JSONArray.parseArray(input);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).toString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] words = stringToStringArray(line);

            int ret = new Solution().minimumLengthEncoding(words);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}