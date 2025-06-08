package com.yablokovs.LC_v3.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class SegmentTreeMyImplementationTest {


    @Test
    void testSegmentTreeState() {
        int[] input = {1, 3, 5, 7, 9, 11};
        SegmentTreeMyImplementation segmentTree = new SegmentTreeMyImplementation();
        segmentTree.build(input);




    }

}