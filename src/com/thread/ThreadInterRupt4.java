package com.thread;

public class ThreadInterRupt4 implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted() && i <= 10000) {
            if (i % 100 == 0) {
                System.out.println(i + " 是100的倍数");
            }
            i++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadInterRupt4());
        thread.start();
        try {
            thread.sleep(5000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
