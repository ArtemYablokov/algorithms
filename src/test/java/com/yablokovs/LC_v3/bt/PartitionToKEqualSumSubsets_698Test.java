package com.yablokovs.LC_v3.bt;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionToKEqualSumSubsets_698Test {

    @Test
    void canPartitionKSubsets() {
        PartitionToKEqualSumSubsets_698 solution = new PartitionToKEqualSumSubsets_698();

//        int _5 = 1 | 1 << 2;
//        String s = Integer.toBinaryString(_5);
//        int _1 = _5 & (_5 ^ 1 << 2);

        boolean b1 = solution.canPartitionKSubsets(Util.build(1,1,1,2,2,2), 3);
        boolean b = solution.canPartitionKSubsets(Util.build(4, 3, 2, 3, 5, 2, 1), 4);
        boolean b3 = solution.canPartitionKSubsets(Util.build(2,2,2,2,4), 4);



        int n = 0;
    }
}