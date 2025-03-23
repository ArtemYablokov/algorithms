package com.yablokovs.leetcode.v2.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedSetTest {

    @Test
    void test() {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.remove(0);
        boolean insert = randomizedSet.insert(0);
//        randomizedSet.getRandom();
//        randomizedSet.remove(1);
//        randomizedSet.insert(2);
//        randomizedSet.getRandom();

    }
}
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
//        [[], [1], [2], [2], [], [1], [2], []]