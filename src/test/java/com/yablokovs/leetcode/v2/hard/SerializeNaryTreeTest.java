package com.yablokovs.leetcode.v2.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SerializeNaryTreeTest {

    @Test
    void serializeAndDe() {
        int[] a1 = new int[] {1,11,1};
        int[] a2 = new int[] {1,11,1};

        String string1 = Arrays.toString(a1);
        String string2 = Arrays.toString(a2);

        Set<String> set = new HashSet<>();
        boolean add = set.add(string1);
        boolean contains = set.contains(string2);
        boolean add2 = set.add(string2);


        SerializeNaryTree serializeNaryTree = new SerializeNaryTree();
        SerializeNaryTree.Node deserialize = serializeNaryTree.deserialize(" 1 [ 3 [ 5   6  ]  2   4  ]");
    }
}