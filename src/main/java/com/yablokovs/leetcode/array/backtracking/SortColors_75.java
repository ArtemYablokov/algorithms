package com.yablokovs.leetcode.array.backtracking;

public class SortColors_75 {

    //     s     e
    // 0 2 2 0 1 0
    // 0 0 2 2 1 0
    // 0 0 0 2 1 2
    // end OOB
    //       s     e
    // WHITE e = s + 1
    //           s e
    // 0 0 0 2 1 2
    // 0 0 0 1 2 2

    public int[] sort(int[] nums) {
        if (nums.length == 1)
            return nums;
        int start = 0;
        int current = nums[start];

        for (int color = 0; color < 2; color++) {
            int end = start + 1;
            while (end < nums.length) {
                int replacement = nums[end];

                if (current == color) { // move on
                    current = nums[++start];
                    end++;
                } else {
                    // increment END to find RED
                    if (replacement != color) {
                        end++;
                    } else {
                        nums[start] = replacement;
                        nums[end] = current;
                        current = replacement;
                    }
                }
            }
        }
        return nums;
    }
}
