package com.yablokovs.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

class ConcatenatedWordsDP472Test {

    @Test
    void findAllConcatenatedWordsInADict() {

        ConcatenatedWords_HARD concatenatedWords472 = new ConcatenatedWords_HARD();
//        List<String> allConcatenatedWordsInADict = concatenatedWords472.findAllConcatenatedWordsInADict(new String[]{
//                "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","aaaaaaaaaaa","aaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaaaaaaaaa","aaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaz"
//        });

        List<String> allConcatenatedWordsInADict = concatenatedWords472.findAllConcatenatedWordsInADict(new String[]{
                "cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"
        });

    }
}