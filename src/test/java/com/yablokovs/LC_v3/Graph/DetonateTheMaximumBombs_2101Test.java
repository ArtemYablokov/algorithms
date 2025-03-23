package com.yablokovs.LC_v3.Graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetonateTheMaximumBombs_2101Test {

    @Test
    void maximumDetonation() {
//        int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
        int[][] bombs2 = {{2, 1, 3}, {6, 1, 4}};

        DetonateTheMaximumBombs_2101 solution = new DetonateTheMaximumBombs_2101();
        int i = solution.maximumDetonation(bombs2);

        int n = 0;
    }
}