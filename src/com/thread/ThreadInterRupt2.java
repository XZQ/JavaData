package com.thread;

public class ThreadInterRupt2 implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (i <= 300) {
            if (i % 100 == 0) {
                System.out.println(i + " 是100的倍数");
            }
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadInterRupt2());
        thread.start();
        try {
            thread.sleep(500);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
