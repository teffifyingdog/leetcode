package com.wjc.lc.twenty.tree.twentytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description
 * @Date 2020/3/22 0022 下午 12:05
 * @Created by wjc
 * <p>
 * 链接
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 */

class Solution {
    public int minIncrementForUnique(int[] A) {
        int res = 0;
        Arrays.sort(A);
        System.out.println("A = " + Arrays.toString(A));
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                res += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return res;

//        int[] count = new int[80000];
//        for (int x: A) count[x]++;
//
//        int ans = 0, taken = 0;
//
//        for (int x = 0; x < 80000; ++x) {
//            if (count[x] >= 2) {
//                taken += count[x] - 1;
//                ans -= x * (count[x] - 1);
//            }
//            else if (taken > 0 && count[x] == 0) {
//                taken--;
//                ans += x;
//            }
//        }
//
//        return ans;
//        HashSet hashSet = new HashSet<Integer>();
//        int res = 0;
//        for (int i = 0; i < A.length; i++) {
//            while (!hashSet.add(A[i])){
//                A[i]+=1;
//                res++;
//            }
//        }
//        return res;
    }
}

public class 使数组唯一的最小增量 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);

            int ret = new Solution().minIncrementForUnique(A);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}