package com.yablokovs.leetcode.v2.bs;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void findPeakGrid() {
        Solution solution = new Solution();
        int[][] ints = {
                {47, 30, 35, 8, 25},
                {6, 36, 19, 41, 40},
                {24, 37, 13, 46, 5},
                {3, 43, 15, 50, 19},
                {6, 15, 7, 25, 18}
        };
        solution.findPeakGrid(ints);
    }
}