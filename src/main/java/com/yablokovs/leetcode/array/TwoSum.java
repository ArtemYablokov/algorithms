package com.yablokovs.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static void main(String[] args) {

    }

    public int[] twoSumN2(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }


    public int[] twoSum2N(int[] nums, int target) {
        Map<Integer, Integer> indexToValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexToValue.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            Integer integer = indexToValue.get(target - current);
            if (integer != null && integer != i) {
                return new int[]{i, integer};
            }
        }





        return null;
    }
}
