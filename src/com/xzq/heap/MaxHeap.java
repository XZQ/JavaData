package com.xzq.heap;


public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap() {
        data = new Array<E>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<E>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }


    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index " + index + " doesn't parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 像堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);//添加到最后，
        siftUp(data.getSize() - 1);

    }

    /**
     * 维护堆的顺序
     *
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 下一个左孩子
     *
     * @param index
     * @return
     */
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 下一个右孩子
     *
     * @param index
     * @return
     */
    public int rightChild(int index) {
        return index * 2 + 2;
    }


    // 看堆中的最大元素
    public E findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }


    // 取出堆中最大元素
    public E extractMax() {
        E e = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return e;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }
}
