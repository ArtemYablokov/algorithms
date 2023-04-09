package com.yablokovs.leetcode.linkedList;

public class FindTheDuplicateNumberM287 {

    /**
     * Floyd's cycle detection.
     *
     * не сразу понял что Linked List не нужно создавать отдельно. По сути массив и есть Linked List (Cycled)
     * это достигается с помощью указателей.
     * */

    public int findDuplicate(int[] nums) {
        int slowPointer = 0;
        int fastPointer = 0;

        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        } while (slowPointer != fastPointer);

        int starterPointer = 0;

        do {
            slowPointer = nums[slowPointer];
            starterPointer = nums[starterPointer];
        } while (slowPointer != starterPointer);
        return starterPointer;
    }

}
