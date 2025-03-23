package com.yablokovs.leetcode.HARD.trie;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestValidStringTest {

    @Test
    void longestValidSubstring() {

        LengthOfLongestValidString lll = new LengthOfLongestValidString();


        int i = lll.longestValidSubstring("cbaaaabc", List.of("aaa", "cb"));


    }
}