package com.yablokovs.leetcode.array;

public class SearchInRotatedSortedArray_M_33 {
    public int search(int[] nums, int target) {
        return searchArray(nums, 0, nums.length - 1, target);
    }

    private int searchArray(int[] nums, int start, int end, int target) {
        System.out.println("start = " + start);
        System.out.println("end = " + end);

        if (start > end)
            return -1;

        int center = (start + end) / 2;
        int centerVal = nums[center];
        int startVal = nums[start];
        int endVal = nums[end];

        if (centerVal == target)
            return center;

        if (startVal < centerVal) {
            if (startVal <= target && target < centerVal)
                return searchArray(nums, start, center - 1, target); // LEFT
            else
                return searchArray(nums, center + 1, end, target); // RIGHT
        } else {
            if (centerVal < target && target <= endVal)
                return searchArray(nums, center + 1, end, target); // RIGHT
            else
                return searchArray(nums, start, center - 1, target); // LEFT
        }
    }
}
