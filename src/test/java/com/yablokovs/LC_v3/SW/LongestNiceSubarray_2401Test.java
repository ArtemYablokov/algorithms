package com.yablokovs.LC_v3.SW;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestNiceSubarray_2401Test {

    @Test
    void longestNiceSubarray() {
        LongestNiceSubarray_2401 s = new LongestNiceSubarray_2401();
        int i = s.longestNiceSubarray(Util.build(1, 3, 8, 48, 10));
    }
}