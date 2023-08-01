package com.yablokovs.leetcode.array.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniquePaths_62 {

    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        if (m > n) { // n bigger than m
            m = m + n;
            n = m - n;
            m = m - n;
        }

        int[] dp = new int[n - 1];

        for(int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for(int j = 0; j < m - 1; j++) {
            int current = 1;
            for(int i = 0; i < dp.length; i++) {
                current += dp[i];
                dp[i] = current;
            }
        }

        return dp[n - 1 - 1];
    }
    public int uniquePaths_fact(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int total = m + n - 2; // 3

        if (m > n)
            m = n;  // m should be small

        return fact_FAIL(total, m - 1);
    }

    private int fact_FAIL(int top, int down) {
        int topLimit = top - down;

        Set<Integer> dividers = new HashSet<>();
        for (int i = 0; i < down; i++) {
            dividers.add(down - i);
        }

        List<Integer> tops = new ArrayList<>();
        for (int i = 0; i < topLimit; i++) {
            tops.add(top - i);
        }

        long multiply = 1L;

        for (int t : tops) {

            for (int d : dividers) {

                if (top % d == 0) {
                    dividers.remove(d);
                    top = top / d;
                    break;
                }

            }

        }
        return (int) multiply;
    }
}
