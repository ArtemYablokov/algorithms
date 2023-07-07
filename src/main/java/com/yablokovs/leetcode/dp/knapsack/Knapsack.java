package com.yablokovs.leetcode.dp.knapsack;

public class Knapsack {

    public int knapsack(int capacity, int[] weights, int[] values) {

        int[] dp = new int[capacity + 1];

        for (int i = 0; i < weights.length; i++) {
            for (int currentCapacity = 0; currentCapacity < capacity + 1; currentCapacity++) {

                int diff = currentCapacity - weights[i];
                if (diff == 0) {
                    dp[currentCapacity] = Math.max(dp[currentCapacity], values[i]);
                }
                if (diff > 0) {
                    dp[currentCapacity] = Math.max(dp[currentCapacity], values[i] + dp[diff]);
                }
            }
        }
        return dp[capacity];
    }
}
