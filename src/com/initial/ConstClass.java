package com.initial;

public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world!";

    public ConstClass() {
        System.out.println("ConstClass ()!");
    }
}