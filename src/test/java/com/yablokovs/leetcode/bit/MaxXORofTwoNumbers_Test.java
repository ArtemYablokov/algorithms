package com.yablokovs.leetcode.bit;

import org.junit.jupiter.api.Test;

class MaxXORofTwoNumbers_Test {

    @Test
    void findMaximumXOR() {

        int i = Integer.parseInt("101", 2);
        String string = Integer.toBinaryString(i);


        MaxXORofTwoNumbers maxXORofTwoNumbers421 = new MaxXORofTwoNumbers();
        int maximumXOR = maxXORofTwoNumbers421.findMaximumXOR_MASK( 1, 2, 3);
        int maximumXORtree = maxXORofTwoNumbers421.findMaximumXORtree( 1, 2, 3);


        int n = 0;

    }
}