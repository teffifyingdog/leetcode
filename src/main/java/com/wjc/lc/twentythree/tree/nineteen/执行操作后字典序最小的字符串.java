package com.wjc.lc.twentythree.tree.nineteen;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/lexicographically-smallest-string-after-applying-operations/
 */

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        List<String> res = new ArrayList<>();
        dfs(s, a, b, res, true);
        dfs(s, a, b, res, false);
        return res.stream().sorted((x, y) -> {
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) > y.charAt(i)) {
                    return 1;
                } else if (x.charAt(i) < y.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        }).collect(Collectors.toList()).get(0);
    }

    private void dfs(String s, int a, int b, List<String> res, boolean isAdd) {

        StringBuilder t = new StringBuilder();
        int l = s.length();
        if (isAdd) {
            int[] chars = new int[l];
            for (int i = 0; i < s.toCharArray().length; i++) {
                if (i % 2 != 0) {
                    int j = (int) s.charAt(i) - 48 + a;
                    chars[i] = j > 10 ? j % 10 : j;
                }else {
                    chars[i] = (int) s.charAt(i) - 48;
                }
            }
            for (int c : chars) {
                t.append(c);
            }
        } else {
            char[] chars = s.toCharArray();
            for (int i = l - b; i < l; i++) {
                t.append(chars[i]);
            }
            for (int i = b - 1; i < l - b; i++) {
                t.append(chars[i]);
            }
        }
        System.out.println(t);
        if (!res.contains(t.toString())) {
            res.add(t.toString());
            dfs(t.toString(), a, b, res, true);
            dfs(t.toString(), a, b, res, false);
        }
    }


}

public class 执行操作后字典序最小的字符串 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            int a = Integer.parseInt(line);
            line = in.readLine();
            int b = Integer.parseInt(line);

            String ret = new Solution().findLexSmallestString(s, a, b);

            String out = (ret);

            System.out.print(out);
        }
    }
}