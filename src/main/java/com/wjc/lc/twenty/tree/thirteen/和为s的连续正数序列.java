package com.wjc.lc.twenty.tree.thirteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description
 * @Date 2020/3/13 0013 下午 23:13
 * @Created by wjc
 */

class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        ArrayList<int[]> arrayList = new ArrayList<>();
        while (target / 2 >= left) {
            if (target>sum){
                sum+=right;
                right++;
            }else if (target<sum){
                sum-=left;
                left++;
            }else {
                int[] res = new int[right-left];
                for (int i = left; i < right; i++) {
                    res[i-left]=i;
                }
                arrayList.add(res);
                sum-=left;
                left++;
            }
        }
        return arrayList.toArray(new int[arrayList.size()][]);
    }
}

public class 和为s的连续正数序列 {
    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
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
            int target = Integer.parseInt(line);

            int[][] ret = new Solution().findContinuousSequence(target);

            String out = int2dArrayToString(ret);

            System.out.print(out);
        }
    }
}