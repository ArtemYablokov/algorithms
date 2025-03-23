package com.yablokovs.LC_v3.Greedy;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSidewayJump_1824Test {

    @Test
    void minSideJumps() {
        MinimumSidewayJump_1824 solution = new MinimumSidewayJump_1824();
        int i = solution.minSideJumps(Util.build(0, 1, 2, 3, 0));

    }
}