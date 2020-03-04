package com.xzq.stack;


import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack {

    private Object[] elementData;
    //指向栈顶的指针
    private int top;
    //栈的总容量
    private int size;

    public ArrayStack() {
        this.elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }

    public ArrayStack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity is not :" + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.top = -1;
        this.size = initialCapacity;
    }

    /**
     * 存入元素
     *
     * @param object
     */
    public void push(Object object) {
        ensureExplicitCapacity(top + 1);
        elementData[++top] = object;
    }

    public Object pop() {
        Object obj = peek();
        remove();
        return obj;
    }

    public void remove() {
        elementData[top] = null;
        this.top--;
    }


    /**
     * 获取栈顶元素
     *
     * @return
     */
    public Object peek() {
        if (top < 0) {
            throw new EmptyStackException();
        }
        return elementData[top];
    }

    /**
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        int oldCapacity = size; //之前的容量
        if (minCapacity >= oldCapacity) {//需要扩容
            int newCapacity = 0;
            if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = (oldCapacity << 1);
            }
            this.size = newCapacity;
            elementData = Arrays.copyOf(elementData, size);
        }
    }

    /**
     * 栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, top));
        res.append('[');
        for (int i = 0; i < top; i++) {
            res.append(elementData[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
