package com.yablokovs.leetcode.v2.dp;

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int t = target;
        if (n == 1) return t <= k ? 1 : 0;

        int[] dp = new int[t + 1];
        for (int i = 1; i < k + 1; i++) {
            dp[i] = 1;
        }
        int max = 0;

        for (int i = 2; i < n + 1; i++) {
            int[] cur = new int[t + 1];

            cur[i] = 1;
            System.out.println("i = " + i);
            int j = i + 1;
            while (j < t + 1) {
                System.out.println("j = " + j);
                cur[j] = cur[j - 1] + dp[j - 1];
                if (j - k - 1 >= 0) cur[j] -= dp[j - k - 1];

                if (cur[j] == 0) {
                    break;
                }
                j++;
            }

            if (cur[t] > max) max = cur[t];
            if (cur[t] < max) break;
            dp = cur;
        }

        return max;
    }
}