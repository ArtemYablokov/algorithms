package com.yablokovs.leetcode.math;

public class SQRT {
    public int mySqrt(int x) {
        int i = 1;
        int j = x / 2; // 4
        // 2147483647
        while ( i <= j) {
            int m = (i + j) / 2; // 2
            long multi  = (long)m * m;
            if ( multi > x ) {
                j = m - 1;
            } else if ( multi < x) {
                i = m + 1;
            } else { // m * m = x
                return m;
            }
        }
        if ((long)i * i > x) return i - 1;

        return i;

    }
}
