package com.yablokovs.leetcode.HARD;

import org.junit.jupiter.api.Test;

class ConcatenatedWordsDPTest {

    @Test
    void findAllConcatenatedWordsInADict() {

        ConcatenatedWordsDP concatenatedWordsDP = new ConcatenatedWordsDP();
        concatenatedWordsDP.findAllConcatenatedWordsInADict(new String[]{"cats","dog","dogcatsdog"});
    }
}