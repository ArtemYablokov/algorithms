package com.yablokovs.leetcode.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharacterReplacementTest {

    @Test
    void characterReplacement() {
        LongestRepeatingCharacterReplacement replacement = new LongestRepeatingCharacterReplacement();
        replacement.characterReplacement("ABAB", 2);
        replacement.characterReplacement("JSDSSMESSTR", 2);

    }
}