package com.superexends;

/**
 * @author XZQ
 * @date 2020/3/25 15:42
 */
public class Plate<T extends Fruit> {

    private T item;


    public Plate() {

    }

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
