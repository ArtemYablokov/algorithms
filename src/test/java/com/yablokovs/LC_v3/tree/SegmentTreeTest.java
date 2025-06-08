package com.yablokovs.LC_v3.tree;

import org.junit.jupiter.api.Test;

class SegmentTreeTest {


    @Test
    void testSegmentTreeOperations() {
        int[] arr = {2, 7, 1,
                3, 6, 3, 7, 4, 3, 3}; // 29
        SegmentTree segmentTree = new SegmentTree(arr);

        // 1st query: sum of range [0, 9]
        int sum0 = segmentTree.query(3, 9);
        System.out.println("Sum init: " + sum0);
        segmentTree.printTree();

        // 1st update: update range [2, 5] by adding 10
        segmentTree.update(2, 5, 3);

        // 1st query: sum of range [0, 9]
        int sum1 = segmentTree.query(3, 9);
        System.out.println("Sum after 1st update: " + sum1);

        // 2nd update: update range [0, 3] by adding 5
        segmentTree.update(4, 8, 5);

        // 3rd update: update range [7, 9] by subtracting 3
        segmentTree.update(5, 9, -3);

        // 2nd query: sum of range [4, 8]
        int sum2 = segmentTree.query(4, 8);
        System.out.println("Sum after 2nd and 3rd updates: " + sum2);
    }


    @Test
    void testSegmentTreeLargeArray() {
            int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
            SegmentTree segmentTree = new SegmentTree(arr);

            // Initial sum of the whole array
            int expectedSum = 0;
            for (int v : arr) expectedSum += v;
            assert segmentTree.query(0, 19) == expectedSum;

            // Update range [0, 9] by +2
            segmentTree.update(0, 9, 2);
            int sumFirstHalf = 0;
            for (int i = 0; i < 10; i++) sumFirstHalf += arr[i] + 2;
            for (int i = 10; i < 20; i++) sumFirstHalf += arr[i];
            assert segmentTree.query(0, 19) == expectedSum + 2 * 10;

            // Query subrange [5, 15]
            int expectedSubSum = 0;
            for (int i = 5; i <= 9; i++) expectedSubSum += arr[i] + 2;
            for (int i = 10; i <= 15; i++) expectedSubSum += arr[i];
            assert segmentTree.query(5, 15) == expectedSubSum;

            // Update range [10, 19] by -3
            segmentTree.update(10, 19, -3);
            int expectedSumAfter = expectedSum + 2 * 10 - 3 * 10;
            assert segmentTree.query(0, 19) == expectedSumAfter;

            // Query single element [0,0]
            assert segmentTree.query(0, 0) == arr[0] + 2;

            // Update range [0, 19] by +1
            segmentTree.update(0, 19, 1);
            expectedSumAfter += 20;
            assert segmentTree.query(0, 19) == expectedSumAfter;

            // Query subrange [15, 19]
            int expectedTail = 0;
            for (int i = 15; i < 20; i++) expectedTail += arr[i] - 3 + 1;
            assert segmentTree.query(15, 19) == expectedTail;
        }
}