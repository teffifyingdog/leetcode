package com.wjc.lc.twentyone.twelve.twentysix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int l = nums3.length;
        if (l==0) {
            return 0;
        }
        for (int i = 0, j = 0; j + i < l; ) {
            if (i >= nums1.length) {
                nums3[i + j] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                nums3[i + j] = nums1[i];
                i++;
            } else {
                if (nums1[i] >= nums2[j]) {
                    nums3[i + j] = nums2[j];
                    j++;
                } else {
                    nums3[i + j] = nums1[i];
                    i++;
                }
            }
        }
        if (l % 2 == 0) {
            int i = l / 2;
            return ((double) nums3[i-1]+nums3[i])/2;
        }
        return nums3[l/2];
    }
}

public class MedianOfTwoSortedArrays {
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

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);

            double ret = new Solution().findMedianSortedArrays(nums1, nums2);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}