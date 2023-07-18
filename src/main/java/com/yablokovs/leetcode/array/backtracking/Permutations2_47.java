package com.yablokovs.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }


    private void permute(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(temp);
            return;
        }
        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (visited[i] || !uniqueNums.add(current)) {
                continue;
            }
            visited[i] = true;
            ArrayList<Integer> newTemp = new ArrayList<>();
            newTemp.add(current);
            permute(nums, result, newTemp, visited);
            visited[i] = false;

        }
    }
}
