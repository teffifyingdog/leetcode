package com.wjc.lc.twentytwo.temp;

public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(i * 2 + 1);
                    try {
                        notifyAll();
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 50; i++) {
                    System.out.println(i * 2 + 2);
                    try {
                        notifyAll();
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}
