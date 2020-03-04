package com.thread;


/**
 * 两个线程交替打印0~100的奇偶数，用synchronized关键字实现
 */
public class OddEvenClass1 {

    private static int count;
    private static Object obj = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (obj) {
                        if ((count & 1) == 0) {
                            System.out.println("偶数" + ":" + count++);
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (obj) {
                        if ((count & 1) == 1) {
                            System.out.println("奇数" + ":" + count++);
                        }
                    }
                }
            }
        }).start();


    }
}

