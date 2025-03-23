package com.yablokovs.LC_v3.SW;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstring_76_HARDTest {

    @Test
    void minWindow() {

        MinimumWindowSubstring_76_HARD solution = new MinimumWindowSubstring_76_HARD();
        String s = solution.minWindow("AAB", "AB");
        String s2 = solution.minWindow("ADOBECODEBANC", "ABC");
        String s3 = solution.minWindow("AAAABBABA", "AABB");
        String s4 = solution.minWindow("uwqkzuyotckqcusdiqubeqglkvuocttzrllqfjhzorpqnjwxbqyfiessx", "qsvczwsslkhwg");

        int n = 0;
    }
}