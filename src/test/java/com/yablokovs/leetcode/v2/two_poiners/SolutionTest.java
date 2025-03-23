package com.yablokovs.leetcode.v2.two_poiners;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findRLEArray() {

        Solution solution = new Solution();
        List<List<Integer>> rleArray = solution.findRLEArray(new int[][]{{1, 3}, {2, 3}}, new int[][]{{6, 3}, {3, 3}} );

    }
}