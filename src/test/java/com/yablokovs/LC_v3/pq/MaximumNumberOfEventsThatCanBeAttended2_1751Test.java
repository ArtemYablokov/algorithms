package com.yablokovs.LC_v3.pq;

import org.junit.jupiter.api.Test;

class MaximumNumberOfEventsThatCanBeAttended2_1751Test {

    @Test
    void maxValue() {
        int[][] a = new int[][]{
                {19, 42, 7}, {41, 73, 15}, {52, 73, 84}, {84, 92, 96}, {6, 64, 50}, {12, 56, 27}, {22, 74, 44}, {38, 85, 61}};

        MaximumNumberOfEventsThatCanBeAttended2_1751 solution = new MaximumNumberOfEventsThatCanBeAttended2_1751();
        solution.maxValue(a, 5);
    }
}