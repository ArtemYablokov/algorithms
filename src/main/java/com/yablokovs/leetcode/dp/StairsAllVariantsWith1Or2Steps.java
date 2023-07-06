package com.yablokovs.leetcode.dp;

import java.util.Arrays;

/*
* https://leetcode.com/problems/climbing-stairs/submissions/
* */

public class StairsAllVariantsWith1Or2Steps {

    public static void main(String[] args) {
        System.out.println(calculateLikeFibonacciOptimizedMemory(6));

    }

    private static int calculateLikeFibonacciOptimizedMemory(int n) {
        if (n < 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 2; i < n; i++) {
            second += first;
            first = second - first;
        }
        return second;
    }


    private static int calculateLikeFibonacci(int n) {
        int[] stairs = new int[n];

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        stairs[0] = 1;
        stairs[1] = 2;

        for (int i = 2; i < n; i++) {
            stairs[i] = stairs[i-1] + stairs[i-2];
        }

        return stairs[n - 1];
    }


    private static int calculateStraight(int n) {
        int[] stairs = new int[n+1];

        int length = stairs.length;

        for(int i = 0; i < length - 2; i++) {
            stairs[i + 1] = stairs[i] + 1;
            stairs[i + 2] = stairs[i] + 1;
            System.out.println(Arrays.toString(stairs));

        }
        System.out.println(Arrays.toString(stairs));

        stairs[length - 2] = stairs[length - 3] + 1;
        stairs[length - 1] = stairs[length - 2] + 1;
        System.out.println(Arrays.toString(stairs));

        stairs[length - 1] = stairs[length - 2] + 1;



        return stairs[length - 1];

    }
}
