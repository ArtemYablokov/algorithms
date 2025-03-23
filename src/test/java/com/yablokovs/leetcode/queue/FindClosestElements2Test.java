package com.yablokovs.leetcode.queue;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class FindClosestElements2Test {

    @Test
    public void test() {
        FindClosestElements2 findClosestElements2 = new FindClosestElements2();
        List<Integer> closestElements = findClosestElements2.findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, 3);
        Collections.sort(closestElements);
        int n = 0;
    }

}