package com.wjc.lc.twentythree.six.fiveteen;

import java.util.Arrays;

/**
 * @author 28600
 * <a href="https://leetcode.cn/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75">...</a>
 */
public class 压缩字符串 {
    public static int compress(char[] chars) {
        char t = chars[0];
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == t) {
                num++;
            } else {
                sb.append(t);
                sb.append(num);
                t = aChar;
                num = 1;
            }
        }
        sb.append(t);
        sb.append(num);
        char[] res = sb.toString().toCharArray();
        int min = Math.min(res.length, chars.length);
        System.arraycopy(res, 0, chars, 0, min);
        return sb.length();
    }

    public static void main(String[] args) {
//        char[] chars = {'a','a','a','b','b','b','c','c','c','c'};
        char[] chars = {'a'};
        System.out.println(compress2(chars));
        System.out.println(Arrays.toString(chars));
    }

    public static int compress2(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

}
