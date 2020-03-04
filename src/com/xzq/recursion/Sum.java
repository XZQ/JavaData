package com.xzq.recursion;

public class Sum {
    public static int sum(int[] args) {
        return subSum(args, 0);
    }

    public static int subSum(int[] args, int i) {
        if (i == args.length) {
            return 0;
        }
        return args[i] + subSum(args, i + 1);
    }


    public static void main(String[] args) {
        int[] ints = new int[100];
        for (int i = 0; i < 100; i++) {
            ints[i] = i;
        }
        System.out.println(sum(ints));
    }
}
