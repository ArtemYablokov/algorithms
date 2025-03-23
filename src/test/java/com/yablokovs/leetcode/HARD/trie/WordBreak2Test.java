package com.yablokovs.leetcode.HARD.trie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreak2Test {

    @Test
    void wordBreak() {
        WordBreak2 wordBreak2 = new WordBreak2();

        List<String> cat = new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"));
        List<String> list = wordBreak2.wordBreak("catsanddog", cat);
    }
}