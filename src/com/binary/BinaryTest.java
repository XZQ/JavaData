package com.binary;

import java.util.Arrays;

/**
 * @author XZQ
 * @date 2020/3/12 19:04
 */
public class BinaryTest {

    public static void main(String[] args) {
        String[] ints = {"0", "1", "2", "3", "4", "5", "6,", "7", "8", "9"};

        String[] strings=Arrays.copyOfRange(ints, 0, 5);
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
