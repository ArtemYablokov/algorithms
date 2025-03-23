package com.yablokovs.leetcode.v2.sort;

import java.util.Arrays;

public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        // sort by ends and greedily visit earliest day of each
        int count = 0;
        boolean[] dp = new boolean[(int)1e6];
        for (int[] e : events) {
            for (int n = e[0]; n <= e[1]; n++) {

                if (!dp[n]) {
                    System.out.println("n =" + n);
                    System.out.println("e end =" + e[1]);
                    dp[n] = true;
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
