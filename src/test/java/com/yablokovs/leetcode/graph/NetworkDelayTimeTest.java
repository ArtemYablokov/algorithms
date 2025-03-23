package com.yablokovs.leetcode.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkDelayTimeTest {

    @Test
    void networkDelayTime() {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int[][] ints = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        networkDelayTime.networkDelayTime(ints, 4, 2);
    }
}