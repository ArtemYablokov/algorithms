package com.yablokovs.leetcode.v2.hard;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void maxSumOfThreeSubarrays() {

        Solution s = new Solution();
        int[] ints0 = {7, 1, 3, 2, 5, 2, 4, 8, 3, 1, 4};
//        s.maxSumOfThreeSubarrays(ints0, 2);

        int[] ints1 = {1, 2, 1, 2, 6, 7, 5, 1};
        int[] _1 = s.maxSumOfThreeSubarrays(ints1, 2);

        int[] ints2 = {1, 2, 1, 2, 1, 2, 1, 2, 1};
        int[] _2 = s.maxSumOfThreeSubarrays(ints2, 2);

        int[] ints3 = {7, 1, 3, 2, 5, 2, 4, 8, 3, 1, 4};
        int[] _3 = s.maxSumOfThreeSubarrays(ints3, 2);

        int[] ints4 = {4, 3, 2, 1};
        int[] _4 = s.maxSumOfThreeSubarrays(ints4, 1);
    }
}