package com.xzq.heap;


public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
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

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }
}
