package com.yablokovs.leetcode.HARD.trie;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConcatenatedWords_472Test {

    @Test
    void findAllConcatenatedWordsInADict() {

        ConcatenatedWords_472 concatenatedWords472 = new ConcatenatedWords_472();
        List<String> allConcatenatedWordsInADict = concatenatedWords472.findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"});

        concatenatedWords472.minMeetingRooms(new int[][]{{0,1}});
    }
}