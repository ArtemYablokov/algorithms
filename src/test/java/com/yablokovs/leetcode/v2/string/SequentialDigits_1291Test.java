package com.yablokovs.leetcode.v2.string;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequentialDigits_1291Test {

    @Test
    void sequentialDigits() {
        SequentialDigits_1291 sequentialDigits1291 = new SequentialDigits_1291();

        List<Integer> integers = sequentialDigits1291.sequentialDigits(100, 300);
    }
}