package com.yablokovs.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(result, nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }

    private void permutations(List<List<Integer>> result, int[] nums, boolean[] visited, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(current);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            ArrayList<Integer> temp = new ArrayList<>(current);
            temp.add(nums[i]);
            visited[i] = true;
            permutations(result, nums, visited, temp);
            visited[i] = false;
        }
    }
}
