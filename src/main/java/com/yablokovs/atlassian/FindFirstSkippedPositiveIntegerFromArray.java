package com.yablokovs.atlassian;

import java.util.Arrays;

public class FindFirstSkippedPositiveIntegerFromArray {

    public static void main(String[] args) {

        int[] array = new int[]{0, 0, -2, 0, 4, 3, 1 };
        System.out.println(calculateRefactoring(array));

    }

    private static int calculateRefactoring(int[] array) {
        Arrays.sort(array);

        int previous = 0;
        int counter = 0;

        for (int current : array) {
            if (current < 1) {
                continue;
            }
            if (current != previous) {
                counter++;
            }
            if (current != counter) {
                return counter;
            }
            previous = current;
        }
        return ++counter;
    }



    private int calculateStraight(int[] array) {
//        int[] array = new int[5];

        Arrays.sort(array);

        int min = 0;
        int previous = 0;

        for (int current : array) {
            if (current < 1) {
                continue;
            }
            if (current == previous) {
                continue;
            } else {
                previous = current;
                min++;
            }
            if (current != min) {
                return min;
            }
        }
        return ++min;
    }
}
