package com.yablokovs.leetcode.v2.bs;

import org.junit.jupiter.api.Test;

class MaximumNumberOfRemovableCharacters_1898Test {

    @Test
    void maximumRemovals() {
        MaximumNumberOfRemovableCharacters_1898 maximumNumberOfRemovableCharacters1898 = new MaximumNumberOfRemovableCharacters_1898();
        int i = maximumNumberOfRemovableCharacters1898.maximumRemovals("abcacb", "ab", new int[]{3, 1, 0});
    }
}