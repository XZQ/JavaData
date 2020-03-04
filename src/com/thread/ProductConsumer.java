package com.thread;

import java.util.Date;
import java.util.LinkedList;

public class ProductConsumer {

    public static void main(String[] args) throws InterruptedException {
        Storage storage = new Storage();
        Thread thread1 = new Thread(new Producer(storage));
        Thread thread2 = new Thread(new Consumer(storage));
        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}

class Consumer implements Runnable {
    Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.take();
        }
    }
}

class Producer implements Runnable {

    Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();
        }
    }
}

class Storage {
    private int maxSize;
    private LinkedList<Date> storage;

    public Storage() {
        this.maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void put() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里生产了" + storage.size() + "个产品。");
        notify();
    }

    public synchronized void take() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了" + storage.poll() + "，现在仓库还剩下" + storage.size());
        notify();
    }
}