package com.yablokovs.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        getSubsets(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }

    private void getSubsets(List<List<Integer>> subsets, List<Integer> currentSubset, int[] nums, int index) {
        if (index == nums.length) {
            subsets.add(currentSubset);
            return;
        }
        ArrayList<Integer> empty = new ArrayList<>(currentSubset);
        List<Integer> full = new ArrayList<>(currentSubset);
        full.add(nums[index]);

        getSubsets(subsets, empty, nums, index + 1);
        getSubsets(subsets, full, nums, index + 1);
    }
}
