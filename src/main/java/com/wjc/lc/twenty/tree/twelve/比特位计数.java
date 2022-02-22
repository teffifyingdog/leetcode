package com.wjc.lc.twenty.tree.twelve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/3/12 0012 下午 15:32
 * @Created by wjc
 * <p>
 * 链接
 * https://leetcode-cn.com/problems/counting-bits/
 */

class Solution {
    public int[] countBits(int num) {
        if (0<=num){
            int[] ints = new int[num+1];
            for (int i = 0; i <= num; i++) {
                ints[i]=ints[i>>1]+(i&1);
            }
            return ints;
        }
        return new int[]{};
//        if (0 <= num) {
//            int[] ints = new int[num + 1];
//            for (int i = 0; i <= num; i++) {
//                int res = Integer.bitCount(i);
//                ints[i] = res;
//            }
//            return ints;
//        }
//        return new int[]{};
    }

}

public class 比特位计数 {
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
            int num = Integer.parseInt(line);

            int[] ret = new Solution().countBits(num);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
class test{
    public static void main(String[] args) {
        System.out.println(1>>1);
    }
}