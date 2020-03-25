package com.superexends;

/**
 * @author XZQ
 * @date 2020/3/25 15:46
 */
public class Main {

    public static void main(String[] args) {
        Plate<? extends Fruit> plate = new Plate<GreenApple>();
        plate.getItem();
    }
}
