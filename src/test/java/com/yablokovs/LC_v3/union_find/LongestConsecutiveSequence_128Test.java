package com.yablokovs.LC_v3.union_find;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequence_128Test {

    @Test
    void longestConsecutive() {
        LongestConsecutiveSequence_128 solution = new LongestConsecutiveSequence_128();

        int i = solution.longestConsecutive(Util.build(100, 4, 200, 1, 3, 2));
    }
}