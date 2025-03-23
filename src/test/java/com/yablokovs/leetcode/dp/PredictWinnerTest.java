package com.yablokovs.leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredictWinnerTest {

    @Test
    void predictTheWinner() {

        PredictWinner predictWinner = new PredictWinner();
        int[] ints = {1, 5, 233, 7};
        predictWinner.predictTheWinner(ints);
    }
}