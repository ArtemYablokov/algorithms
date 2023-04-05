package com.yablokovs.leetcode.backtracking;

public class BestTimeBuySellStock121 {

    public static int maxProfit(int[] prices) {

//        if (prices.length == 1) return 0;
        int currentMin = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currentMin) {
                currentMin = prices[i];
                continue;
            }
            profit = Math.max(profit, prices[i] - currentMin);
        }
        return profit;
    }

    public static void main(String[] args) {
        int i = maxProfit(new int[]{7, 2, 5, 2, 6, 4});
        int j = maxProfit(new int[]{7,6,4,3,1});
        int n = 0;
    }
}
