package com.yablokovs.LC_v3.dp;

import java.util.Arrays;

public class KnightDealer_935 {
    int MOD = (int) 1e9 + 7;

    public int knightDialer(int n) {
        int[][] dp = new int[4][3];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(dp[i], 1);
        }
        dp[3][0] = 0;
        dp[3][2] = 0;

        for (int i = 0; i < n - 1; i++) {
            int[] local = new int[10];

            for (int j = 0; j < 9; j++) {
                int ix = j / 3;
                int jx = j % 3;

                for (int[] m : moves) {
                    int iN = ix + m[0];
                    int jN = jx + m[1];
                    if ((iN < 3 && iN >= 0 && jN < 3 && jN >= 0) || (iN == 3 && jN == 1)) {
                        local[j] = (dp[iN][jN] + local[j]) % MOD;
                    }
                }
            }

            // it's zero
            local[9] = (dp[1][0] + local[9]) % MOD;
            local[9] = (dp[1][2] + local[9]) % MOD;
            dp[3][1] = local[9];
            for (int j = 0; j < 9; j++) {
                int ix = j / 3;
                int jx = j % 3;

                dp[ix][jx] = local[j];
            }
        }
        int result = 0;

        for (int j = 0; j < 9; j++) {
            int ix = j / 3;
            int jx = j % 3;
            result = (dp[ix][jx] + result) % MOD;
        }
        result = (dp[3][1] + result) % MOD;

        return result;
    }


    int[][] moves = new int[][]{
            {1, 2},
            {2, 1},
            {1, -2},
            {2, -1},
            {-1, 2},
            {-2, 1},
            {-1, -2},
            {-2, -1},
    };

}
