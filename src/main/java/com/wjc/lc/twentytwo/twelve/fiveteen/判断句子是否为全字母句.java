package com.wjc.lc.twentytwo.twelve.fiveteen;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
 */
class Solution1 {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        return set.size() == 26;
    }

    public static void main(String[] args) {
        System.out.println((int)'z');
    }
}

public class 判断句子是否为全字母句 {
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
            String sentence = stringToString(line);

            boolean ret = new Solution1().checkIfPangram(sentence);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}