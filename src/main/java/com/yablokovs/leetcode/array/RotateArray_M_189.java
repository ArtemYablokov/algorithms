package com.yablokovs.leetcode.array;

public class RotateArray_M_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        mirrorArray(nums, 0, nums.length - 1);
        mirrorArray(nums, 0, k - 1);
        mirrorArray(nums, k, nums.length - 1);
    }

    private void mirrorArray(int[] nums, int start, int endIncluded) {
        while (start < endIncluded) {
            int temp = nums[start];
            nums[start] = nums[endIncluded];
            nums[endIncluded] = temp;
            start++;
            endIncluded--;
        }
    }
}
