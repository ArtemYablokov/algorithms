package com.yablokovs.leetcode.v2.ll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestoreArrayFromAdjacentPairs_1743Test {

    @Test
    void restoreArray() {

        RestoreArrayFromAdjacentPairs_1743 restoreArrayFromAdjacentPairs1743 = new RestoreArrayFromAdjacentPairs_1743();
        int[][] ints1 =  {{2, 1}, {3, 4}, {3, 2}};
        int[][] ints2 =  {{1, 2}};
        int[][] ints =  {{1, 4}, {4, -2}, {-3, 1}};
        restoreArrayFromAdjacentPairs1743.restoreArray(ints);

        int[][] move = new int[][] {
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
        };
    }
}

//1 2 3
//
//        4 3 2

//4 1 -3
// 4 -2
// 1 -3
// -2 4 1