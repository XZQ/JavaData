package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XZQ
 * @date 2020/4/21 15:23
 */
public class JavaException {

    public static void main(String[] args) {
//        testValueOf();
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();
        name.add("icon");
        age.add(18);
        number.add(314);
        getData(name);
        getData(age);
        getData(number);

    }

    // 在此处使用通配符，则可以传入各种类型的 List 泛型，
    public static void getData(List<?> data) {
        System.out.println("Test date :" + data.get(0));
    }

    public static void testValueOf() {
        
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = Integer.valueOf(40);
        Integer i5 = Integer.valueOf(40);
        Integer i6 = Integer.valueOf(0);
        Integer i7 = 250;
        Integer i8 = 250;


        System.out.println("i1=i2 \t" + (i1 == i2));
        System.out.println("i1=i2+i3 \t" + (i1 == i2 + i3));
        System.out.println("i4=i5 \t" + (i4 == i5));
        System.out.println("i4=i5+i6 \t" + (i4 == i5 + i6));
        System.out.println("i7=i8 \t" + (i7 == i8));

    }


    public static int test() {
        int ret = 0;
        try {
            System.out.println("16");
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            ret = 10;
        }
        return -1;
    }


}
