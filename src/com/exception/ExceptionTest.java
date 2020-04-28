package com.exception;

/**
 * @author XZQ
 * @date 2020/4/28 17:38
 */
public class ExceptionTest {

    public static void main(String[] args) {
        System.out.println(anInt());//
    }

    public static int anInt() {
        try {
            throw new NullPointerException("NullPointerException try");
        } finally {
            throw new NullPointerException("NullPointerException  finally");
        }
    }
}