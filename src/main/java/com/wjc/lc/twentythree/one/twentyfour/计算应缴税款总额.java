package com.wjc.lc.twentythree.one.twentyfour;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * https://leetcode.cn/problems/calculate-amount-paid-in-taxes/
 */
class Solution1 {
    public double calculateTax(int[][] brackets, int income) {
        int temp = 0;
        double res = 0;
        for (int[] bracket : brackets) {
            if (income - temp > 0){
                res += (Math.min(income,bracket[0])-temp) * bracket[1];
                temp = bracket[0];
            }else {
                break;
            }
        }
        return (double) res /100;
    }
}

public class 计算应缴税款总额 {
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

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] brackets = stringToInt2dArray(line);
            line = in.readLine();
            int income = Integer.parseInt(line);

            double ret = new Solution1().calculateTax(brackets, income);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}