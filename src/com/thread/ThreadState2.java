package com.thread;


/**
 * Blocked, Waiting, TimedWaiting
 */
public class ThreadState2 implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        ThreadState2 runnable = new ThreadState2();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread.sleep(100);

        Thread thread2 = new Thread(runnable);
        thread2.start();
        //打印出Timed_Waiting状态，因为正在执行Thread.sleep(1000);
        System.out.println("T1 " + thread1.getState());
        //打印出BLOCKED状态，因为thread2想拿得到sync()的锁却拿不到
        System.out.println("T2 " + thread2.getState());

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出WAITING状态，因为执行了wait()
        System.out.println(thread1.getState());

    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
