package com.yablokovs.leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    @Test
    void longestConsecutive() {

        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int i = lcs.longestConsecutive(new int[]{0, 0, 1, -1});
    }
}