package com.yablokovs.LC_v3.Greedy;

public class MinimumSidewayJump_1824 {
    int STONE = (int) 1e6;

    public int minSideJumps(int[] obstacles) {
        int[] o = obstacles;
        int l = o.length;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 1; i < l; i++) {
            if (o[i] != 0)
                dp[o[i] - 1] = STONE; // set cur STONE

            for (int k = 0; k < 3; k++) { // for each cur set MAX out of other 2 + 1
                if (o[i] == k + 1)
                    continue; // don't update STONE

                dp[k] = Math.min(dp[k], Math.min(dp[(k + 1) % 3], dp[(k + 2) % 3]) + 1);
            }
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

}
