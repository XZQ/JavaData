package com.offer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OnTest {
    public static void main(String[] args) {

        Date t = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        for (int x = 5; x < 15; x++) {
            long n = (long) Math.pow(10, x);
            long start = System.currentTimeMillis();
//            System.out.println(df.format(start));
            int num = 0;
            for (int i = 0; i < n; i++) {
                num += i;
            }
            long end = System.currentTimeMillis();
            System.out.println(df.format(end));
        }

    }
}
