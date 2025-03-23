package com.yablokovs.leetcode.v2.two_poiners;

public class MinimumTimeToMakeRopeColorful_1578 {

    public int minCost(String colors, int[] neededTime) {
        int[] time = neededTime;
        char[] a = colors.toCharArray();
        int l = a.length;
        int i = 0;
        int result = 0;
        while (i < l) {
            int j = i;
            int min = time[i];
            int minI = i;
            while (j + 1 < l && a[i] == a[j + 1]) {
                j++;
                if (time[j] < min) {
                    min = time[j];
                    minI = j;
                }
            }
            if (i < j) {
                for (int ix = i; ix <= j; ix++) {
                    if (ix == minI)
                        continue;
                    result += time[ix];
                }
            }
            i = j + 1;
        }

        return result;
    }
}

