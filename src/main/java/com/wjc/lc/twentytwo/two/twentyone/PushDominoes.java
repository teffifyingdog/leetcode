package com.wjc.lc.twentytwo.two.twentyone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/push-dominoes/
 */
class Solution {
    public String pushDominoes(String dominoes) {
        int l = dominoes.length();
        char left = 'L';
        char[] chars = dominoes.toCharArray();
        int i = 0;
        while (i < l) {
            int j = i;
            while (j < l && chars[j] == '.') {
                j++;
            }
            char right = j < l ? chars[j] : 'R';
            if (left == right) {
                while (i < j) {
                    chars[i] = right;
                    i++;
                }
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    chars[k--] = 'L';
                    chars[i++] = 'R';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(chars);
    }
}

public class PushDominoes {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {

            String ret = new Solution().pushDominoes(line);

            String out = (ret);

            System.out.print(out);
        }
    }
}