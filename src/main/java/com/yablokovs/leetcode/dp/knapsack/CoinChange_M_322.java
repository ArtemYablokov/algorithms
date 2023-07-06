package com.yablokovs.leetcode.dp.knapsack;

public class CoinChange_M_322 {

    // coins = [1,2,5], amount = 11
    public int coinChange(int[] coins, int amount) {

        int dpSize = amount + 1;
        int[] dpArray = new int[dpSize];
        for (int i = 1; i < dpSize; i++) {
            dpArray[i] = dpSize; // 12
        }
        dpArray[0] = 0;

        for (int i = 0; i < dpSize; i++) {
            for (int coin : coins) {

                int diff = i - coin;
//                if (diff == 0)
//                    dpArray[i] = 1;
                if (diff > 0) {
                    dpArray[i] = Math.min(dpArray[i], dpArray[diff] + 1);
                }
                // if diff < 0 -> coin is greater -> skip
            }
        }

        return dpArray[amount] < dpSize ? dpArray[amount] : -1;
    }


}
