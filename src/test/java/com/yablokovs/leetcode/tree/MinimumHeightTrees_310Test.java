package com.yablokovs.leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

class MinimumHeightTrees_310Test {

    @Test
    void findMinHeightTrees() {

        Integer integer1 = 128;
        Integer integer2 = 128;

        System.out.println(integer1 == integer2);
        System.out.println(integer1.equals(integer2));

        MinimumHeightTrees_310 minimumHeightTrees310 = new MinimumHeightTrees_310();
        List<Integer> minHeightTrees = minimumHeightTrees310.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        List<Integer> minHeightTrees2 = minimumHeightTrees310.findMinHeightTrees(4, new int[][]{{1, 0}, {2, 1}, {3, 1}});
        List<Integer> minHeightTrees3 = minimumHeightTrees310.findMinHeightTrees(2, new int[][]{{1, 0},});
        List<Integer> minHeightTrees4 = minimumHeightTrees310.findMinHeightTrees(15, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {0, 7}, {4, 8}, {5, 9}, {7, 10}, {6, 11}, {0, 12}, {0, 13}, {3, 14}});

        int n = 0;
    }
}