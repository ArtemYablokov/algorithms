package com.yablokovs.LC_v3.Graph;

import org.junit.jupiter.api.Test;

class PathWithMinimumEffort_1631Test {

    @Test
    void minimumEffortPath() {
        int[][] a = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        PathWithMinimumEffort_1631 solution = new PathWithMinimumEffort_1631();
        int i = solution.minimumEffortPath(a);
    }
}