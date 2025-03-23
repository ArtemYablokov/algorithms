package com.yablokovs.leetcode.HARD.queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void addNum() {

        List<int[]> results = new ArrayList<>();

        Integer[] integers = results.toArray(new Integer[results.size()]);


        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(7);
        int n = 0;
    }
}