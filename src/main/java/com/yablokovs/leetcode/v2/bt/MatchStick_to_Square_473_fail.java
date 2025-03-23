package com.yablokovs.leetcode.v2.bt;

import java.util.Arrays;

public class MatchStick_to_Square_473_fail {
    // should i use SET to check ? or MAP -> it is improvement
    // i should use boolean of used

    // boolean[] used;
    int l;
    int[] a;
    int total;
    int fourth;
    int[] square = new int[4];
    boolean[][] dp;

    public boolean makesquare(int[] matchsticks) {
        a = matchsticks;
        l = a.length;
        // used = new boolean[l];

        total = Arrays.stream(a).sum();
        if (total % 4 != 0)
            return false;
        fourth = total / 4;
        Arrays.fill(square, fourth);
        dp = new boolean[4][fourth];
        for (int n : a)
            if (n > fourth)
                return false;

        return bt(0, 0);
    }

    private boolean bt(int ix, int sum) {
        if (sum == total)
            return true;
        int cur = a[ix];
        // try each stick put in any side ?
        // NO !! lets try from side perspective - stick will be predefined as IX
        for (int i = 0; i < 4; i++) {
            int left = square[i] - cur;
            if (left >= 0 && !dp[i][left]) {
                square[i] -= cur;
                boolean b = bt(ix + 1, sum + cur);
                if (b)
                    return true;
                dp[i][left] = true;
                // if returned true - no need to change square balance
                // since true means SUCCESS of building SQUARE
                square[i] += cur;
            }
        }
        // there was no success of building with cur STICK :(
        // -> answer of whole problem NO
        return false;
    }
}


