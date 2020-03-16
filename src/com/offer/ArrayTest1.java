package com.offer;

/**
 * @author XZQ
 * @date 2020/3/13 11:15
 * <p>
 * https://www.nowcoder.com/ta/coding-interviews?tagQuery=%E6%95%B0%E7%BB%84&page=1
 */
public class ArrayTest1 {

    public static void main(String[] args) {
        int[][] ints = {{2, 3, 1, 0, 2, 5, 3}, {2, 3, 1, 0, 2, 5, 3}};

    }

    /**
     * 二维数组中的查找
     */
    public static boolean duplicate(int numbers[], int length, int[] duplication) {

//        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
//        int[] newData = new int[1];
//        System.out.println(duplicate(numbers, numbers.length, newData));

        if (length == 0) {
            return false;
        }
        boolean isExit = false;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] == numbers[j]) {
                    duplication[0] = numbers[i];
                    isExit = true;
                    break;
                }
            }
            if (isExit) {
                break;
            }
        }
        if (duplication.length == 0) {
            return false;
        } else {
            return true;
        }
    }
}
