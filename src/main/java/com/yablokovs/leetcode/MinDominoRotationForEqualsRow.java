package com.yablokovs.leetcode;

/*
* https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/submissions/
* limit of 2*10^4 of dominos
* */

public class MinDominoRotationForEqualsRow {
    public static void main(String[] args) {

    }
    private static int withDoublesArray(int[] tops, int[] bottoms) {
        int result = 20000 + 1;

        int[] first = new int[6];
        int[] second = new int[6];
        int[] doubbles = new int[6];

        int currTops;
        int currBottoms;

        // заполнили количество
        for (int i = 0; i < tops.length; i++) {
            currTops = tops[i];
            currBottoms = bottoms[i];

            if (currTops == currBottoms) {
                doubbles[currTops - 1] += 1;
            } else {
                first[currTops - 1] += 1;
                second[currBottoms - 1] += 1;
            }
        }

        for (int i = 0; i < 6; i++) {
            if ((first[i] + second[i] + doubbles[i]) == tops.length) {
                result = Math.min(result, Math.min(first[i], second[i]));
            }
        }
        return result == 20001 ? -1 : result;

    }

    // TODO: 20.03.2022 kind a optimized but slower
    private static int withTotalArray(int[] tops, int[] bottoms) {
        int result = -1;

        int[] first = new int[6];
        int[] second = new int[6];
        int[] total = new int[6];

        int currTops;
        int currBottoms;

        // заполнили количество
        for (int i = 0; i < tops.length; i++ ) {
            currTops = tops[i];
            currBottoms = bottoms[i];

            if ( currTops == currBottoms ) {
                total[currTops - 1] += 1;
            } else {
                total[currTops - 1] += 1;
                total[currBottoms - 1] += 1;

                first[currTops - 1] += 1;
                second[currBottoms - 1] += 1;
            }
        }

        for (int i = 0; i < 6; i++ ) {
            if ( total[i] == tops.length) {
                int min = Math.min(first[i], second[i]);
                if (result == -1) {
                    result = min;
                } else {
                    result = Math.min(result, min);
                }
            }
        }
        return result;

    }
}
