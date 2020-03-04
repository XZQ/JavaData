package com.thread;

public class ThreadState1 {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
        //
        System.out.println("12 " + thread.getState());
        thread.start();
        System.out.println("14 " + thread.getState());
        try {
            thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("21 " + thread.getState());
    }
}
