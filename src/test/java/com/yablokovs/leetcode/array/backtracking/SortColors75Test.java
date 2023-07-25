package com.yablokovs.leetcode.array.backtracking;

import org.junit.jupiter.api.Test;

class SortColors75Test {

    @Test
    void sort() {
        SortColors_75 sortColors75 = new SortColors_75();
        int[] sort = sortColors75.sort(new int[]{0, 2, 2, 0, 1, 0});
        int[] sort0 = sortColors75.sort(new int[]{0});
        int[] sort1 = sortColors75.sort(new int[]{1});
        int[] sort2 = sortColors75.sort(new int[]{2});
        int[] sort21 = sortColors75.sort(new int[]{2, 1});
        int[] sort20 = sortColors75.sort(new int[]{2, 0, 1});
        int n = 0;
    }
}