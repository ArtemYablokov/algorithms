package com.yablokovs.leetcode;

import java.util.Arrays;

public class Common {

    public static void main(String[] args) {
        int total = 10000;
        int interest = 5;

        int interestPayment = 0;

        for (int i = 0; i < 10; i++) {
            int temp = total / 100 * interest;

            interestPayment += temp;

            total -= 1000;

        }


        int[] roots = new int[1];
        long count = Arrays.stream(roots).distinct().count();
    }
}
