package com.yablokovs.leetcode.v2.sw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfSubarrays_1343Test {

    @Test
    void numOfSubarrays() {

        NumberOfSubarrays_1343 numberOfSubarrays1343 = new NumberOfSubarrays_1343();
        int i = numberOfSubarrays1343.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4);
    }
}