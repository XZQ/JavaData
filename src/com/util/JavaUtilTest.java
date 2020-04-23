package com.util;

import java.util.function.Consumer;

/**
 * @author XZQ
 * @date 2020/4/22 18:20
 */
public class JavaUtilTest {


    public static void main(String[] args) {


        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);// 12
        };
        consumer.andThen(consumer);
    }


    public static void forList() {
        //        ArrayList<String> list = new ArrayList<>();
//        list.add("Google");
//        list.add("Android");
//        list.add("Apple");
//Function
//        list.forEach(str ->
//                System.out.println(str)
//        );
//        Iterator<String> iterator = list.iterator();
//        iterator.forEachRemaining(s -> System.out.println(s));
    }

    public void nullParams() {
        Runnable runnable = new Runnable() {
            public void run() {

            }
        };
        Runnable runnable1 = () -> {
            System.out.println();
        };


    }

}
