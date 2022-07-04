package com.wjc.lc.twentytwo.five.nine;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://leetcode.cn/problems/di-string-match/
 */
class Solution {
    public int[] diStringMatch(String s) {
        int length = s.length(), low = 0, high = length;
        int[] res = new int[length + 1];
        for (int i = 0; i < length; i++) {
            res[i] = s.charAt(i) == 'I' ? low++ : high--;
        }
        res[length] = low;
        return res;
    }
}

public class 增减字符串匹配 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int[] ret = new Solution().diStringMatch(s);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}