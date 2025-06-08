package com.yablokovs.LC_v3.math;

import org.junit.jupiter.api.Test;

import static com.yablokovs.LC_v3.util.Util.build;

class CountTheNumberOfKFreeSubsets_2638ERRORTest {

    @Test
    void countTheNumOfKFreeSubsets() {
        CountTheNumberOfKFreeSubsets_2638_ERROR solution = new CountTheNumberOfKFreeSubsets_2638_ERROR();

        long l5 = solution.countTheNumOfKFreeSubsets(build(5, 4, 6), 1);
        long l12 = solution.countTheNumOfKFreeSubsets(build(2, 3, 5, 8), 5);
        long l16 = solution.countTheNumOfKFreeSubsets(build(10, 5, 9, 11), 20);

        int i = 0;
    }
}