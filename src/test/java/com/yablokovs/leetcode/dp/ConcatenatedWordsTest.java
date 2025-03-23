package com.yablokovs.leetcode.dp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConcatenatedWordsTest {

    @Test
    void findAllConcatenatedWordsInADict() {
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        List<String> allConcatenatedWordsInADict = concatenatedWords.findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"});
    }
}