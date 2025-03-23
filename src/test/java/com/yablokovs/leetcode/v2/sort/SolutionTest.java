package com.yablokovs.leetcode.v2.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxEvents() {
        Solution solution = new Solution();
        int i = solution.maxEvents(new int[][]{
                {1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}
        });
    }
}