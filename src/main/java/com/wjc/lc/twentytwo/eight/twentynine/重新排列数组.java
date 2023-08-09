package com.wjc.lc.twentytwo.eight.twentynine;

/**
 * https://leetcode.cn/problems/shuffle-the-array/
 */
public class 重新排列数组 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0,j = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[j];
                j++;
            }else {
                res[i] = nums[n];
                n++;
            }
        }
        return res;
    }
}
