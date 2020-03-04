package com.xzq.tree;

import java.util.ArrayList;
import java.util.Random;

public class BstMain {
    public static void main(String[] args) {
//        Bst<Integer> bst = new Bst<>();
//        int[] ints = {5, 3, 6, 8, 4, 2};
//        for (int i = 0; i < ints.length; i++) {
//            bst.add(ints[i]);
//        }
//        bst.preOrder();
//        System.out.println(bst);
        remove();
    }

    public static void remove() {
        Bst<Integer> bst = new Bst<>();
        Random random = new Random();
        int n = 10;

        // test removeMin
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
            System.out.println(nums);
        }
    }
}
