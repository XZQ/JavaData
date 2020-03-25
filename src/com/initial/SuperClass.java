package com.initial;

public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 1127;

    public SuperClass() {
        System.out.println("SuperClass ()!");
    }
}