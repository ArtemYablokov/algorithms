package com.yablokovs.LC_v3.SuffixArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingSubstring_1062Test {

    @Test
    void longestRepeatingSubstring() {

        LongestRepeatingSubstring_1062 lrs = new LongestRepeatingSubstring_1062();

//        int i = lrs.countK(14);

        int abbaba = lrs.longestRepeatingSubstring("abbaba");
        int abcabd = lrs.longestRepeatingSubstring("abcabd");
        int aabcaabdaab = lrs.longestRepeatingSubstring("aabcaabdaab");
        int abcd = lrs.longestRepeatingSubstring("abcd");
    }
}