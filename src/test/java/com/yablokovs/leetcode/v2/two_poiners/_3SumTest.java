package com.yablokovs.leetcode.v2.two_poiners;

import org.junit.jupiter.api.Test;

import java.util.List;

class _3SumTest {

    @Test
    void threeSum() {
        _3Sum sum = new _3Sum();
        List<List<Integer>> lists = sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}