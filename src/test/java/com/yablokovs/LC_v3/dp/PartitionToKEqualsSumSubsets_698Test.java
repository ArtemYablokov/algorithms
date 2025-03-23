package com.yablokovs.LC_v3.dp;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionToKEqualsSumSubsets_698Test {

    @Test
    void canPartitionKSubsets() {
        PartitionToKEqualsSumSubsets_698 solution = new PartitionToKEqualsSumSubsets_698();
        boolean b = solution.canPartitionKSubsets(Util.build(4, 3, 2, 3, 5, 2, 1), 4);

    }
}