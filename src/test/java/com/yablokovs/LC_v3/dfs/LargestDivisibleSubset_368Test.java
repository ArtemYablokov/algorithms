package com.yablokovs.LC_v3.dfs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.yablokovs.LC_v3.util.Util.build;
import static org.junit.jupiter.api.Assertions.*;

class LargestDivisibleSubset_368Test {

    @Test
    void largestDivisibleSubset() {

        LargestDivisibleSubset_368 largestDivisibleSubset368 = new LargestDivisibleSubset_368();

        List<Integer> integers = largestDivisibleSubset368.largestDivisibleSubset(build(1, 2, 4, 8));
    }
}