package com.yablokovs.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets2_90_FAIL {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        sub(nums, 0, new ArrayList<>(), result);
        return result;
    }


    private void sub(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(temp);
            return;
        }
        ArrayList<Integer> full = new ArrayList<>(temp);
        full.add(nums[index]);
        sub(nums, index + 1, full, result);

        ArrayList<Integer> empty = new ArrayList<>(temp);
        if (temp.size() == 0 || (nums[index] != temp.get(temp.size() - 1))) {
            sub(nums, index + 1, empty, result);
        }
    }
}
