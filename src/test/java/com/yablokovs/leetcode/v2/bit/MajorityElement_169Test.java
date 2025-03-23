package com.yablokovs.leetcode.v2.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElement_169Test {

    @Test
    void majorityElement() {
        MajorityElement_169 majorityElement169 = new MajorityElement_169();
        int i = majorityElement169.majorityElement(new int[]{-3, 2, -3});

        String s = Integer.toBinaryString(3);
        String s1 = Integer.toBinaryString(-3);
    }
}