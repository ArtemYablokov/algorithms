package com.yablokovs.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicateNlgN(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicateN(int[] nums) {
        Set<Integer> integers = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!integers.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
