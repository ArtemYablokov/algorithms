package com.yablokovs.LC_v3.Graph;

import org.junit.jupiter.api.Test;

class FindClosestNodeToGivenTwoNodes_2359Test {

    @Test
    void closestMeetingNode() {
        int[] ints = {4, 4, 8, -1, 9, 8, 4, 4, 1, 1};
        FindClosestNodeToGivenTwoNodes_2359 val = new FindClosestNodeToGivenTwoNodes_2359();

        int i = val.closestMeetingNode(ints, 5, 6);
    }

}
