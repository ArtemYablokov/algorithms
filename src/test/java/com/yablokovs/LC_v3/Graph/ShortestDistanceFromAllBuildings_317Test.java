package com.yablokovs.LC_v3.Graph;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestDistanceFromAllBuildings_317Test {

    @Test
    void shortestDistance() {
        ShortestDistanceFromAllBuildings_317 solution = new ShortestDistanceFromAllBuildings_317();

        int i = solution.shortestDistance(Util.build2d("[[0,2,1],[1,0,2],[0,1,0]]"));

    }
}