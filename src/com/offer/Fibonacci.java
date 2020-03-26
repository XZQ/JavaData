package com.offer;

/**
 * @author XZQ
 * @date 2020/3/26 11:23
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(rectCover(6));
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
     *
     * @param n
     * @return
     */
    public static int rectCover(int n) {
        if (n <= 2) {
            return n;
        }
        int num = 0;
        int preOne = 1;
        int preTwo = 2;
        while (n > 2) {
            num = preOne + preTwo;
            preOne = preTwo;
            preTwo = num;
            n--;
        }
        return num;
    }

    /**
     * 一只青蛙一次可以跳上1 级台阶，也可以跳上2 级。求该青蛙跳上一
     * 个n 级的台阶总共有多少种跳法
     *
     * @param n
     * @return
     */
    public static long JumpFloor(int n) {
        long result = 0;
        long preOne = 1;
        long preTwo = 2;
        if (n < 3) {
            return n;
        }

        for (int i = 3; i < n; i++) {
            result = preOne + preTwo;
            preOne = preTwo;
            preTwo = result;

        }
        return result;
    }

    /**
     * 递归的效率低，使用循环方式。
     *
     * @param n
     * @return
     */
    public static long fibonacci1(int n) {
        long result = 0;
        long preOne = 1;
        long preTwo = 0;
        //
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        //
        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }

        return result;
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
