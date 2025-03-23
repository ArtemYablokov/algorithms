package com.yablokovs.leetcode.string;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NavigableMap;
import java.util.TreeMap;

class PermutationInStringTest {

    @Test
    void checkInclusion() {

        Deque<Integer> d = new LinkedList<>();

        d.offer(1);
        d.offer(2);
        d.offer(3);
        Integer last = d.getLast();

        NavigableMap<Integer, Integer> map1 = new TreeMap<>();
        map1.put(4, 4);
        map1.put(2, 2);
        map1.put(1, 1);
        map1.put(3, 3);

        Integer integer = map1.lastKey();
        map1.lastEntry();
        Integer integer2 = map1.floorKey(3); // INCLIUDE ITSELF
        Integer integer1 = map1.lowerKey(3); // EXCLUDE ITSELF

        PermutationInString p = new PermutationInString();
        boolean b = p.checkInclusion("ab", "eidbkaooo");
        int n = 0;
    }
}
