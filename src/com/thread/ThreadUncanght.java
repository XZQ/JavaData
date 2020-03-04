package com.thread;

public class ThreadUncanght implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncanghtThread("捕获器1"));
        new Thread(new ThreadUncanght(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new ThreadUncanght(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new ThreadUncanght(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new ThreadUncanght(), "MyThread-4").start();

    }
}
