package com.wjc.lc.twentytwo.eight.seven;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.cn/problems/string-matching-in-an-array/
 */
class Solution {
    public List<String> stringMatching(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j){
                    if (words[i].indexOf(words[j]) != -1) {
                        set.add(words[j]);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

}

public class 数组中的字符串匹配 {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] words = stringToStringArray(line);

            List<String> ret = new Solution().stringMatching(words);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}