package com.wjc.lc.twentytwo.five.fifteen;


import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeAnagrams(String[] words) {

        ArrayList<String> res = new ArrayList();
        int length = words.length;
        if (length == 0) {
            return res;
        }
        res.add(words[0]);
        if (length == 1) {
            return res;
        }
        for (int i = 1; i < length; i++) {
            String a = words[i];
            char[] b = a.toCharArray();
            Arrays.sort(b);
            String c = words[i-1];
            char[] d = c.toCharArray();
            Arrays.sort(d);
            if (b.length == d.length) {
                boolean flag = true;
                for (int j = 0; j < b.length; j++) {
                    if (b[j] != d[j]) {
                        flag = false;
                    }
                }
                if (flag) {
                    continue;
                }
            }
            res.add(a);
        }
        return res;
    }
}

public class 移除字母异位词后的结果数组 {
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

            List<String> ret = new Solution().removeAnagrams(words);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}