package com.yablokovs.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.List;

class PacificAtlanticWaterFlowM417Test {

    @Test
    void pacificAtlantic() {
        int[][] values = new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] heights = new int[][]{{1, 1}, {1, 1}, {1, 1}, };

        PacificAtlanticWaterFlow_M_417 pacificAtlanticWaterFlowM417 = new PacificAtlanticWaterFlow_M_417();
        List<List<Integer>> lists = pacificAtlanticWaterFlowM417.pacificAtlantic(heights);

        int n = 0;

    }
}