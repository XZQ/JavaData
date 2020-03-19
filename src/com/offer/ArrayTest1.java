package com.offer;

/**
 * @author XZQ
 * @date 2020/3/13 11:15
 * <p>
 * https://www.nowcoder.com/ta/coding-interviews?tagQuery=%E6%95%B0%E7%BB%84&page=1
 */
public class ArrayTest1 {

    public static void main(String[] args) {
        System.out.println(replaceStr("we are happy"));
    }

    /**
     * 将一个字符串中的空格替换成“%20”。例如：当字符串为We Are
     * Happy.则经过替换之后的字符串为We%20Are%20Happy
     *
     * @param string
     */
    public static String replaceStr(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (" ".equals(String.valueOf(string.charAt(i)))) {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(string.charAt(i));
            }

        }
        return stringBuilder.toString();

    }


    /**
     * 从右上角或左下角开始找，逐行排除，或者用二分法查找
     */
    public static void find3() {
        int[][] array = {{1, 2, 3, 4, 5}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}};
        int target = 4;

        int left = 0;
        int right = array.length * array[0].length - 1;
        int col = array[0].length;

        while (left <= right) {
            int mid = (left + right) / 2;
            int value = array[mid / col][mid % col];
            if (value == target) {
                return;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right + " " + col);
    }


    /**
     * 遍历
     * 从右上角或左下角开始找，逐行排除，或者用二分法查找
     * 双指针
     */
    public static void find2() {
        int[][] array = {{1, 2, 3, 4, 5}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}};
        int target = 4;

        int row = 0;
        int column = array[0].length - 1;

        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                System.out.println("29");
                return;
            }
            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
    }


    /**
     * 遍历
     * 时间复杂度为O（n^2）,偏高。影响程序的性能。
     */
    public static void find1() {
        int[][] array = {{1, 2, 3, 4, 5}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}};
        int target = 4;
        for (int[] ints : array) {//得到每个1围数组
            for (int ins : ints) {
                if (target == ins) {
                    System.out.println("ins=" + ins);
                    return;
                }
            }
            System.out.println("----------------------");
        }
    }


    /**
     * 二维数组中的查找
     */
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        int[][] array = {{1, 2, 3, 4, 5}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}};

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
