package com.yablokovs.leetcode.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordSearch79Test {


    WordSearch79 wordSearch79 = new WordSearch79();

    @Test
    public void testMethod() {
        String leetword = "ABCCED";
        char[][] leet = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        boolean solution = wordSearch79.solution(leet, leetword);

        Assertions.assertTrue(solution);

    }

}