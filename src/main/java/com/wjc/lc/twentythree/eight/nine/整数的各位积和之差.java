package com.wjc.lc.twentythree.eight.nine;

/**
 * @author 28600
 */
public class 整数的各位积和之差 {
    public static int subtractProductAndSum(int n) {
        int ji = 1;
        int jia = 0;
        while (n > 0) {
            int a = n % 10;
            ji *= a;
            jia += a;
            n = n / 10;
        }
        return ji - jia;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }
}
