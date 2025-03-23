package com.yablokovs.leetcode.v2.bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {

    @Test
    void updateBoard() {
        Minesweeper minesweeper = new Minesweeper();
        char[][] chars = {
                {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}
        };
        char[][] chars1 = minesweeper.updateBoard(chars, new int[]{3, 0});
    }
}