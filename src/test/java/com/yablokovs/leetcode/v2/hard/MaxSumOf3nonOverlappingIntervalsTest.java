package com.yablokovs.leetcode.v2.hard;

import org.junit.jupiter.api.Test;

class MaxSumOf3nonOverlappingIntervalsTest {

    @Test
    void maxSumOfThreeSubarrays() {
        // 9, 20, 14, 15
        // lexi smaller than
        // 5, 17, 20, 16
        // ????

        int[] ints1 = {1, 17, 16, 10, 6, 18, 1, 1, 16, 12, 9, 20, 14, 15, 5, 17, 20, 16, 4, 3, 3, 17, 13, 9, 16, 3, 8, 8, 14, 12, 20, 14, 20, 9, 1, 12, 14, 17, 15, 19};

        MaxSumOf3nonOverlappingIntervals maxSumOf3nonOverlappingIntervals = new MaxSumOf3nonOverlappingIntervals();
        int[] ints = maxSumOf3nonOverlappingIntervals.maxSumOfThreeSubarrays(new int[]{
                1, 2, 1, 2, 6, 7, 5, 1
        }, 2);
    }
}