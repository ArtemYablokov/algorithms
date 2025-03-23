package com.yablokovs.leetcode.graph;

import org.junit.jupiter.api.Test;

class SnakeAndLaddersTest {

    @Test
    void snakesAndLadders() {
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
        int[][] a = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        int[][] b = new int[][]{
                {-1, -1},
                {-1, 3}
        };

        int i = snakeAndLadders.snakesAndLadders(b);
    }
}