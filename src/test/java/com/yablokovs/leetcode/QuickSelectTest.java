package com.yablokovs.leetcode;

import org.junit.jupiter.api.Test;

class QuickSelectTest {

    @Test
    void findKthLargest() {

        QuickSelect quickSelect = new QuickSelect();
//        int[] arr = {3, 2, 1, 5, 6, 4};
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = quickSelect.findKthLargest(arr, 2);

    }
}