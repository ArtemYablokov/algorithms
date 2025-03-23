package com.yablokovs.LC_v3.bt;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

class MaximumRowsCoveredByColumns_2397Test {

    @Test
    void maximumRows() {
        MaximumRowsCoveredByColumns_2397 solution = new MaximumRowsCoveredByColumns_2397();
        int res = solution.maximumRows(new int[][]{
                Util.build(0, 0, 0),
                Util.build(1, 0, 1),
                Util.build(0, 1, 1),
                Util.build(0, 0, 1),
        }, 2);

    }
}