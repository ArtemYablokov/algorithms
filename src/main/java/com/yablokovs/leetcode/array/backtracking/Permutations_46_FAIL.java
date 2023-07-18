package com.yablokovs.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46_FAIL {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        int end = nums.length - 1;

        rotate(nums, start, end, nums.length, result, new ArrayList<>());

        return result;
    }

    // 0, 1
    private void rotate(int[] nums, int start, int end, int rotations, List<List<Integer>> result, List<Integer> accumulator) {
        int leftBound = nums.length - rotations;

        if (start == end) {
            List<Integer> list = new ArrayList<>(accumulator);
            list.add(nums[start]);
            result.add(list);
            return;
        }

        int length = nums.length; // 2


        for (int i = 0; i < rotations; i++) {
            List<Integer> list = new ArrayList<>(accumulator);
            list.add(nums[start]);


            // сюда start передается с учетом рамок  !!!!
            rotate(nums, getStart(start, end, leftBound, length), end, rotations - 1, result, list);




            end = (leftBound + end + 1) % length;
            start = (start + 1) % length;

            int n = 0;
        }
    }

    private int getStart(int start, int end, int leftBound, int length) {
        if (start < end) {
            if (start + 1 == length) {
                return leftBound;
            }
            return start + 1;
        } else {
            if (start + 1 == length) {
                return 0;
            }
            return start + 1;
        }
    }


}
