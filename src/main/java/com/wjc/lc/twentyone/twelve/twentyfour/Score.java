package com.wjc.lc.twentyone.twelve.twentyfour;


import java.util.Scanner;

public class Score {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] ss = line.split(" ");
        int length = Integer.valueOf(ss[1]);
        String[] s1 = in.nextLine().split(" ");
        int[] ints = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            ints[i] = Integer.valueOf(s1[i]);
        }
        int[] res = new int[length];
        int k = 0;
        for (int i = 0; i < length; i++) {
            String str = in.nextLine();
            String[] s = str.split(" ");
            Integer a = Integer.valueOf(s[1]);
            Integer b = Integer.valueOf(s[2]);
            if (s[0].equals("Q")) {
                Integer min = Math.min(a, b);
                Integer max = Math.max(a, b);
                int temp = 0;
                for (int j = min - 1; j <= max - 1; j++) {
                    temp = Math.max(temp, ints[j]);
                }
                res[k] = temp;
                k++;
            }
            if (s[0].equals("U")) {
                ints[a - 1] = b;
            }
        }
        for (int i = 0; i < k ; i++) {
            System.out.println(res[i]);
        }
    }

}
