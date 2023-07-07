package com.yablokovs.leetcode.dp.knapsack;

import org.junit.jupiter.api.Test;

class KnapsackTest {

    @Test
    void knapsack() {
        Knapsack k = new Knapsack();
//        int[] w = {4, 3, 5, 2};
//        int[] v = {5, 2, 7, 1};
        int[] w = {2, 1, 3};
        int[] v = {3, 2, 4};

        int res = k.knapsack(5, w, v);

        int n = 0;
    }
}