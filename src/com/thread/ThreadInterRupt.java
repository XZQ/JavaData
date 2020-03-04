package com.thread;

public class ThreadInterRupt implements Runnable {

    @Override
    public void run() {
        int i = 0;
//        while (i <= Integer.MAX_VALUE / 2) {
//            if (i % 10000 == 0) {
//                System.out.println(i + " 是10000的倍数");
//            }
//            i++;
//        }
        while (!Thread.currentThread().isInterrupted() && i <= Integer.MAX_VALUE / 2) {
            if (i % 10000 == 0) {
                System.out.println(i + " 是10000的倍数");
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadInterRupt());
        thread.start();
        try {
            thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
