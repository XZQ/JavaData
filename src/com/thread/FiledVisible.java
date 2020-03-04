package com.thread;

import com.company.Array;

import java.util.ArrayList;

public class FiledVisible {
      int a = 1;
      int b = 2;


    private void change() {
        b = a;
        System.out.println("a=" + a + ";b=" + b);
        a = 3;
        System.out.println("a=" + a + ";b=" + b);
    }


    private void print() {
        System.out.println("a=" + a + ";b=" + b);
    }

    public static void main(String[] args) {
        ArrayList<String> stringArray=new ArrayList<>();
        stringArray.add("中国");
        System.out.println(stringArray.toArray().toString());

//        while (true) {
//            FiledVisible test = new FiledVisible();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    test.change();
//                }
//            }).start();

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    test.print();
//                }
//            }).start();

//        }

    }

}
