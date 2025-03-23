package com.yablokovs.LC_v3.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.yablokovs.LC_v3.util.Util.build;

class MinimumHeightTrees_310Test {

    @Test
    void findMinHeightTrees() {
        MinimumHeightTrees_310 minimumHeightTrees310 = new MinimumHeightTrees_310();
//        [[0, 1],[0, 2],[0, 3],[3, 4],[4, 5]]
        List<Integer> minHeightTrees = minimumHeightTrees310.findMinHeightTrees(6, new int[][]{
                build(1, 0),
                build(2, 0),
                build(3, 0),
                build(3, 4),
                build(4, 5),

        });
    }
}