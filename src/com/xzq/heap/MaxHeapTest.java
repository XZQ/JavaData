package com.xzq.heap;

public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap maxHeap=new MaxHeap();
        for (int i = 0; i < 10; i++) {
            maxHeap.add(i);
        }

        System.out.println(""+maxHeap.toString());
    }
}
