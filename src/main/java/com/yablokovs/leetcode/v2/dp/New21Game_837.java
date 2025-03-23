package com.yablokovs.leetcode.v2.dp;

public class New21Game_837 {
    // max - what is available
    // k - stop drawing
    // probsability that has n or fewer points

    // tagret accuray == 1e-6

//    double[] dp;

    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) return 1;
        double dp[] = new double[N + 1],  Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K) Wsum += dp[i]; else res += dp[i];
            if (i - W >= 0) Wsum -= dp[i - W];
        }
        return res;
    }

// test case
// k = 3 - stop draw
// max = 2
// n = 2


}
