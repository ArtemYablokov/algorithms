package com.yablokovs.LC_v3.trie;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

import static com.yablokovs.LC_v3.util.Util.build;
import static org.junit.jupiter.api.Assertions.*;

class FindTheLengthOfTheLongestCommonPrefix_3043Test {

    @Test
    void longestCommonPrefix() {
        FindTheLengthOfTheLongestCommonPrefix_3043 solution = new FindTheLengthOfTheLongestCommonPrefix_3043();

        int i1 = solution.longestCommonPrefix(build(123, 1456), build(12, 145));
    }
}