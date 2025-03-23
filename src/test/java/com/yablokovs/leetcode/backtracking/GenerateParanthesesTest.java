package com.yablokovs.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParanthesesTest {

    @Test
    void generateParenthesis() {
        GenerateParantheses generateParantheses = new GenerateParantheses();
        List<String> strings = generateParantheses.generateParenthesis(2);
    }
}