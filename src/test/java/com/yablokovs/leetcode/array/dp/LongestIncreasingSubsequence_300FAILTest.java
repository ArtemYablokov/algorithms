package com.yablokovs.leetcode.array.dp;

import org.junit.jupiter.api.Test;

class LongestIncreasingSubsequence_300FAILTest {

    @Test
    void lengthOfLIS() {
        LongestIncreasingSubsequence_300_FAIL longestIncreasingSubsequence300 = new LongestIncreasingSubsequence_300_FAIL();

        int[] test1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] test = {1,3,4,2,5,3,7};
        int i = longestIncreasingSubsequence300.lengthOfLIS_FAIl(test);
        int n = 0;


        int i1 = longestIncreasingSubsequence300.lengthOfLIS_binary2(test1);
        int i2 = longestIncreasingSubsequence300.lengthOfLIS_binary(test);
        int i3 = longestIncreasingSubsequence300.lengthOfLIS_wtf(test);

    }
}