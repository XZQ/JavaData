package com.xzq.queue;

import java.util.Arrays;

public class LoopQueue<E> {
    /**
     * 承载队列元素的数组
     */

    private E[] data;

    /**
     * 队首的位置
     */

    private int front;

    /**
     * 队尾的位置
     */

    private int tail;

    /**
     * 队列中元素的个数
     */

    private int size;


    /**
     * 指定容量，初始化队列大小
     * (由于循环队列需要浪费一个空间，所以我们初始化队列的时候，要将用户传入的容量加1)
     *
     * @param capacity
     */

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    /**
     * 模式容量，初始化队列大小
     */

    public LoopQueue() {
        this(8);
    }

    private int getCapacity() {
        // 注意：在初始化队列的时候，我们有意识的为队列加了一个空间，那么它的实际容量自然要减1
        return data.length - 1;
    }

    /**
     * 入队
     *
     * @param e
     */
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            ensuerExplicitCapacity(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public E denqueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // 元素出队后，可以指定条件，进行缩容
        if (size == getCapacity() / 2 && getCapacity() / 2 != 0) {
            ensuerExplicitCapacity(getCapacity() / 2);
        }
        return e;
    }

    // 队列快满时，队列扩容；元素出队操作，指定条件可以进行缩容
    private void ensuerExplicitCapacity(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }


    public int getSize() {
        return size;

    }


    public boolean isEmpty() {
        return front == tail;
    }

    public String toString() {
        return "LoopQueue{" +
                "【队首】data=" + Arrays.toString(data) + "【队尾】" +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                ", capacity=" + getCapacity() +
                '}';
    }
}

