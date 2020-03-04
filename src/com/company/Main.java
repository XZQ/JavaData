package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        ArrayQueue<Integer> arr = new ArrayQueue<>();
//        for (int i = 0; i < 1000000; i++) {
//            arr.enqueue(i);
//        }
//       System.out.println(arr);
//
//        arr.add(1, 100);
//        System.out.println(arr);

//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(4);
//        System.out.println(arr);
//
//        arr.removeFirst();
//        System.out.println(arr);
//
//        for (int i = 0; i < 4; i++) {
//            arr.removeFirst();
//            System.out.println(arr);
//        }

//        Integer[] data = new Integer[5];
//        Integer[] newData = new Integer[10];
//        System.arraycopy(data, 0, newData, 0, data.length);
//        System.out.println(data.toString() + " " +newData );

        int opt = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time = testLoop(arrayQueue, opt);
        System.out.println("ArrayQueue time is  " + time);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testLoop(loopQueue, opt);
        System.out.println("LoopQueue time is  " + time2);
    }

    public static double testLoop(Queue<Integer> queue, int opt) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opt; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opt; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void test() {
        for (int i = 0; i < 20; i++) {
            System.out.print((i + 1) % 10 + " ");
        }
    }
}
