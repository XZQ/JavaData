package com.movearrays;

import java.util.ArrayList;

/**
 * @author XZQ
 * @date 2020/3/16 19:33
 */
public class MoveTest {

    public static void main(String[] args) {
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = i;

        }
        findSequeue(arr, 6);
    }

    /**
     * 滑动窗口解决
     *
     * @param arr
     * @param sum
     */
    public static void findSequeue(int[] arr, int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int pRight = 2;
        int pLeft = 0;

        while (pLeft < pRight) {
            //滑动窗口的和
            int num = ((arr[pLeft] + arr[pRight]) * (arr[pRight] - arr[pLeft] + 1)) / 2;
            if (num == sum) {//满足条件
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = pLeft; i <= pRight; i++) {
                    list.add(i);
                }
                result.add(list);
                pLeft++;
                continue;
            }
            if (num > sum) {
                pLeft++;
            } else {
                pRight++;
            }
        }

        if (!result.isEmpty()) {
            for (ArrayList<Integer> integers : result) {
                System.out.println(integers.toString());
            }
        }
    }


}
