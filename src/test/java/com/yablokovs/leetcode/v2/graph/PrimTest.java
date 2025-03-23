package com.yablokovs.leetcode.v2.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimTest {

    @Test
    void minCostConnectPoints() {
        Prim prim = new Prim();
        prim.minCostConnectPoints(new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}});
    }
}