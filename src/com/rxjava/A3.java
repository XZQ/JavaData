package com.rxjava;

public class A3 extends A {
    private A a;

    //传入A对象
    public A3(A a) {
        this.a = a;
    }

    public A3(){

    }
    // 实现go方法，打印a2,并调用a.go
    @Override
    public void go() {
        System.out.println("aaa " + " a3");
        a.go();
    }
}