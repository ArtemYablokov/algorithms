package com.yablokovs.leetcode.v2.bt;

import java.util.Arrays;

public class MatchStick_to_Square_473 {
    // 1 memo completed set + bitmask of used sticks -> dp[][]
    // 2 try to fill up set one by one (from set perspective)

    boolean[][] dp = new boolean[3][1 << 16]; // if 3 sets completed -> success

    int fourth;
    int[] a;
    int l;
    boolean[] used;

    public boolean makesquare(int[] matchsticks) {
        a = matchsticks;
        l = a.length;
        used = new boolean[l];

        // Arrays.sort(a);
        int total = Arrays.stream(a).sum();
        if (total % 4 != 0)
            return false;
        fourth = total / 4;


        return bt(0, 0, 0);
    }

    private boolean bt(int completedSet, int sum, int memo) {
        if (completedSet == 3)
            return true;
        if (sum > fourth)
            return false;
        if (sum == fourth)
            return bt(completedSet + 1, 0, 0);

        for (int i = 0; i < l; i++) {
            if (used[i])
                continue;
            used[i] = true;
            memo |= 1 << i;

            if (!dp[completedSet][memo]) {
                boolean b = bt(completedSet, sum + a[i], memo);
                if (b)
                    return true;
            }

            dp[completedSet][memo] = true; // TRUE means that it's invalid state

            used[i] = false;
            memo ^= 1 << i;
        }
        return false;
    }
}
