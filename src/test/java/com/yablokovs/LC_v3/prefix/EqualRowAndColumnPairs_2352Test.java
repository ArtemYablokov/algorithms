package com.yablokovs.LC_v3.prefix;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualRowAndColumnPairs_2352Test {

    @Test
    void equalPairs() {

        int[][] ints = Util.build2d("[[3,2,1],[1,7,6],[2,7,7]]");

        EqualRowAndColumnPairs_2352 task = new EqualRowAndColumnPairs_2352();
        int i = task.equalPairs(ints);
    }
}