package com.yablokovs.leetcode.HARD;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {


    public int numOfArrays(int n, int m, int k) {

        int lRight = k + 1;
        int lLeft = n - lRight;

        int result = 0;
        for (int i = m; i > 0; i--) {
            double rightMulti = Math.pow(i, lRight);

            int opposite = m - i + 1;

            double leftMulti = Math.pow(opposite, lLeft);

            result += leftMulti * rightMulti;
        }

        return result;
    }
}
