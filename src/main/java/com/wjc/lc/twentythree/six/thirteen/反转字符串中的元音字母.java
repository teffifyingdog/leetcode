package com.wjc.lc.twentythree.six.thirteen;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 28600
 * <a href="https://leetcode.cn/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75">...</a>
 */
class Solution2 {
    private static final List<Character> CHARS = new ArrayList<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (!isVowel(array[i])) {
                i++;
            } else if (!isVowel(array[j])) {
                j--;
            }else {
                if (array[i] != array[j]) {
                    char t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
                i++;
                j--;
            }
        }
        return String.valueOf(array);
    }
    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}

public class 反转字符串中的元音字母 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = new Solution2().reverseVowels(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}