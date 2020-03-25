package com.initial;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }

    public SubClass() {
        System.out.println("SubClass ()!");
    }
}