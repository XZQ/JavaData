package com.offer;

/**
 * @author XZQ
 * @date 2020/3/19 16:18
 * https://blog.csdn.net/fightforyourdream/article/details/16843303
 */
public class BinarySearch {

    //
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11 };
        int key = 7;
        System.out.println(commonBinarySearch(arr, key));
    }


    /**
     * 递归
     *
     * @param arr
     * @param target
     * @return
     */
    static boolean recursionBinarySearch(int[] arr, int target) {
        return recursionBinarySearch(arr, target, 0, arr.length - 1);
    }

    static boolean recursionBinarySearch(int[] arr, int target, int low, int high) {
        if (arr[low] > target || arr[high] < target || low > high) {
            return false;
        }
        int middle = (low + high) / 2;

        if (arr[middle] == target) {
            return true;
        } else if (arr[middle] > target) {
            return recursionBinarySearch(arr, target, low, middle - 1);
        } else {
            return recursionBinarySearch(arr, target, middle + 1, high);
        }
    }


    /**
     * 普通遍历写法
     *
     * @param arr
     * @param target
     * @return
     */
    static boolean commonBinarySearch(int[] arr, int target) {
        if (arr == null) {
            return false;
        }
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;//中间值

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] == target) {
                return true;
            }
            if (target < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return false;
    }
}
