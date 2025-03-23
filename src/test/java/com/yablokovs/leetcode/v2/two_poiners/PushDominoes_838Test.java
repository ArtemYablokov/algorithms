package com.yablokovs.leetcode.v2.two_poiners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PushDominoes_838Test {

    @Test
    void pushDominoes() {
        PushDominoes_838 pushDominoes838 = new PushDominoes_838();
//        String s = pushDominoes838.pushDominoes(".L.R...LR..L..");
        String s = pushDominoes838.pushDominoes(".L.R.");
    }
}