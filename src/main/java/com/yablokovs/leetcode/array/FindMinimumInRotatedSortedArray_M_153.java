package com.yablokovs.leetcode.array;

public class FindMinimumInRotatedSortedArray_M_153 {


    public int findMin(int[] nums) {
        return getMin(nums, 0, nums.length - 1);
    }

    private int getMin(int[] nums, int s, int e) {
        int min = nums[s];
        int max = nums[e];

        if (min <= max) {
            return min;
        }

        int midIndex = (e + s) / 2;
        int mid = nums[midIndex];


        if (min <= mid) // center at asc part
            return getMin(nums, s + 1, e); // R
        else
            return getMin(nums, s, e - 1); // L
    }

}
