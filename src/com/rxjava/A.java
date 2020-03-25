package com.rxjava;

// 这是一个抽象类，A1,A2,A3都继承此类，并且实现了go的方法
public abstract class A {

    public abstract void go();

    // 创建A1
    public static A createA1() {
        return new A1();
    }

    // 创建A2
    public A createA2() {
//        return new A2(this);
        return new A2();
    }

    // 创建A3
    public A createA3() {
        return new A3(this);
    }
}