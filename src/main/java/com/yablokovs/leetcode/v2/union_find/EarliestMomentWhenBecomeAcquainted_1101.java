package com.yablokovs.leetcode.v2.union_find;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestMomentWhenBecomeAcquainted_1101 {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));

        return 0;
    }
}
