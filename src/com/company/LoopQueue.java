package com.company;


/**
 * 循环队列
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;//第一个元素
    private int tail;//最后一个元素的下一个位置
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        //判断队列是否已经满了
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        //
        tail = (tail + 1) % data.length;
        //
        size++;
    }

    /**
     * 数组扩容
     *
     * @param capacity
     */
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int j = 0; j < size; j++) {
            newData[j] = data[(j + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue form a queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException(" queue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue size=%d, capacity=%d\n ", size, getCapacity()));
        res.append("Front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(i);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append(" tail ]");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
