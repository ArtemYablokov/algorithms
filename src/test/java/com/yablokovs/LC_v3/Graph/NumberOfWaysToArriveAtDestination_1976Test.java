package com.yablokovs.LC_v3.Graph;

import org.junit.jupiter.api.Test;

import static com.yablokovs.LC_v3.util.Util.build;
import static com.yablokovs.LC_v3.util.Util.build2d;

class NumberOfWaysToArriveAtDestination_1976Test {

    @Test
    void countPaths() {
        NumberOfWaysToArriveAtDestination_1976 task = new NumberOfWaysToArriveAtDestination_1976();
//        int i = task.countPaths(2, new int[][]{
//                build(1, 0, 10),
//        });


        int i2 = task.countPaths(7,
                build2d("[[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]")
        );

    }
}