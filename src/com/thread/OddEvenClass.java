package com.thread;


public class OddEvenClass {

    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        thread1.start();
        Thread thread2 = new Thread(new Thread2());
        thread2.start();

    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            while (count <=100) {
                synchronized (lock) {
                    System.out.println("偶数:" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println( "奇数:" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}

