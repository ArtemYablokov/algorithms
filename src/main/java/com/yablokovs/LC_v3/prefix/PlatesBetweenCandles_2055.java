package com.yablokovs.LC_v3.prefix;

public class PlatesBetweenCandles_2055 {


    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] a = s.toCharArray();

        // one array holds what should be excluded (it will populate postponed)
        // another one - what included

        int[] left = new int[a.length];

        int totalPlates = 0;
        int prevCandle = -1;
        int plates = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '*') {
                plates++;
            } else {
                totalPlates += plates;
                plates = 0;
                for (int j = i; j > prevCandle; j--) {
                    left[j] = totalPlates;
                }
                prevCandle = i;
            }
        }

        int[] right = new int[a.length];
        totalPlates = 0;
        plates = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '*') {
                plates++;
            } else {
                totalPlates += plates;
                plates = 0;
            }
            right[i] = totalPlates;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            res[i] = right[q[1]] - left[q[0]];
            if (res[i] < 0) res[i] = 0;
        }
        return res;
    }
}
