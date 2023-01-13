package com.yablokovs.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        addInteger(new ArrayList<>(), nums, 0, result);

        result.add(new ArrayList<>());

        return result;
    }

    private static void addInteger(List<Integer> current, int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) return;

        ArrayList<Integer> arrayList = new ArrayList<>(current);
        addInteger(arrayList, nums, i + 1, result);

        System.out.println();

        ArrayList<Integer> arrayListWith = new ArrayList<>(current);
        arrayListWith.add(nums[i]);
        result.add(arrayListWith);
        addInteger(arrayListWith, nums, i + 1, result);
    }

    public static void main(String[] args) {

        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3, 4,});

    }


}
