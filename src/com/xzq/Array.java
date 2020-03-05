package com.xzq;


import java.util.Arrays;

/**
 * https://www.cnblogs.com/ysocean/category/1120217.html
 * @param <E>
 */
public class Array<E> {

    private Object objects[];
    private int size;
    private int capacity;

    public Array(int capacity) {
        objects = new Object[capacity];
    }

    public Array() {
        this(10);
    }

    public Object[] getData() {
        return objects;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param object
     */
    public void addFirst(Object object) {
        add(0, object);
    }

    /**
     * @param object
     */
    public void addLast(Object object) {
        add(size, object);
    }

    /**
     * @param index
     * @param object
     */
    public void add(int index, Object object) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        ensureExplicitCapacity();
        for (int i = size - 1; i > index; i--) {
            objects[i + 1] = objects[i];
        }
        objects[index] = object;
        size++;
    }

    public Object remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed. Require index >= 0 and index <= size.");
        }
        Object cur = objects[index];
        for (int i = index + 1; i < objects.length; i++) {
            objects[i - 1] = objects[i];
        }
        size--;
        objects[size] = null;

        if (objects.length > 0 && size == objects.length / 4 && objects.length / 2 != 0) {
            System.out.println("缩量操作 " + capacity);
            capacity = (capacity >> 1);
            objects = Arrays.copyOf(objects, capacity);
        }
        return cur;
    }

    public Object getFirst() {
        return get(0);
    }

    // 获取index索引位置的元素
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return objects[index];
    }

    public Object getLast() {
        return get(size - 1);
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        objects[index] = e;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public Object removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public Object removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 查找数组中是否有元素e
    public boolean contains(Object e) {
        for (Object object : objects) {
            if (object.equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(Object e) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 扩容一倍
     */
    private void ensureExplicitCapacity() {
        if (size >= objects.length) {//队列已经满了
            int newCapacity = 0;
            if ((size << 1) - Integer.MAX_VALUE > 0) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = (size << 1);
            }
            this.capacity = newCapacity;
            objects = Arrays.copyOf(objects, capacity);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        Object e = objects[i];
        objects[i] = objects[j];
        objects[j] = e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, capacity));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(objects[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
