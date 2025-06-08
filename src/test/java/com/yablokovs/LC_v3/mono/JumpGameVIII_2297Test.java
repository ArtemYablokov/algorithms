package com.yablokovs.LC_v3.mono;

import org.junit.jupiter.api.Test;

import static com.yablokovs.LC_v3.util.Util.build;
import static org.junit.jupiter.api.Assertions.*;

class JumpGameVIII_2297Test {

    @Test
    void minCost() {
        // 3,2,4,4,1 costs = 3,7,6,4,2

        JumpGameVIII_2297 jg = new JumpGameVIII_2297();
        long l = jg.minCost(build(3, 2, 4, 4, 1), build(3, 7, 6, 4, 2));
    }
}