package com.wjc.lc.twenty.tree.eighteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Date 2020/3/18 0018 下午 21:59
 * @Created by wjc
 *
 * https://leetcode-cn.com/playground/new/empty/
 */

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//        return test(rec1,rec2)||test(rec2,rec1);
        return !(rec1[3]>=rec2[3]||rec1[1]<=rec2[1]||rec1[0]<rec2[0]||rec1[2]>rec2[2]);
    }

    private boolean test(int[] rec1, int[] rec2) {
        if ((rec1[0]==rec2[0]&&rec1[1]==rec2[1])||(rec1[2]==rec2[2]&&rec1[3]==rec2[3])){
            return true;
        }
        if ((rec1[0]>rec2[0]&&rec1[0]<rec2[2])&&(rec1[1]>rec2[1]&&rec1[1]<rec2[3])) {
            return true;
        }
        if ((rec1[2]>rec2[0]&&rec1[2]<rec2[2])&&(rec1[1]>rec2[1]&&rec1[1]<rec2[3])) {
            return true;
        }
        if ((rec1[0]>rec2[0]&&rec1[0]<rec2[2])&&(rec1[3]>rec2[1]&&rec1[3]<rec2[3])) {
            return true;
        }
        if ((rec1[2]>rec2[2]&&rec1[0]<rec2[2])&&(rec1[3]>rec2[1]&&rec1[3]<rec2[3])) {
            return true;
        }
        return false;
    }
}

public class 矩形重叠 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] rec1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] rec2 = stringToIntegerArray(line);

            boolean ret = new Solution().isRectangleOverlap(rec1, rec2);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}