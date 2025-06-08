package com.yablokovs.LC_v3.Greedy;

import org.junit.jupiter.api.Test;

import static com.yablokovs.LC_v3.util.Util.build;

class MaximumValueOfAnOrderedTriplet_2_2874Test {

    @Test
    void maximumTripletValue() {
        MaximumValueOfAnOrderedTriplet_2_2874 solution = new MaximumValueOfAnOrderedTriplet_2_2874();

        long l = solution.maximumTripletValue(build(15, 12, 2, 14, 15, 18, 15, 20));
    }
}