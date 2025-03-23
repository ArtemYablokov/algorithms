package com.yablokovs.leetcode.v2.tree;

import org.junit.jupiter.api.Test;

class TreeDiameter_1245Test {

    @Test
    void treeDiameter() {

        TreeDiameter_1245 treeDiameter1245 = new TreeDiameter_1245();
        treeDiameter1245.treeDiameter(new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}
        });
    }
}