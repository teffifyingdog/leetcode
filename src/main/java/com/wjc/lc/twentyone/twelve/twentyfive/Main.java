package com.wjc.lc.twentyone.twelve.twentyfive;

import java.util.Scanner;
import java.util.HashSet;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        HashSet<Integer> set = new HashSet();
        int n = s.nextInt();
        int res = 0;
        if(n/10 > 0){
            int a = n%10;
            if(set.add(a)){
                res = res * 10 + a;
            }
        }
        System.out.println(res);
    }
}