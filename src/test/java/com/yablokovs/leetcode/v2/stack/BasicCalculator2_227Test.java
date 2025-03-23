package com.yablokovs.leetcode.v2.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculator2_227Test {

    @Test
    void calculate() {
        BasicCalculator2_227 basicCalculator2227 = new BasicCalculator2_227();
//        basicCalculator2227.calculate(" 3+ 2* 2  ");
        basicCalculator2227.calculate(" 3+5 / 2 ");
    }
}