package com.yablokovs.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        sumUnique(candidates, result, 0, 0, target, new ArrayList<Integer>());
        return result;
    }


    private void sumUnique(int[] candidates, List<List<Integer>> result, int index, int currentSum, int target, List<Integer> temp) {
        if (currentSum == target) {
            result.add(temp);
            return;
        }
        if (index == candidates.length || target < currentSum)
            return;

        int current = candidates[index];

        List<Integer> newTemp = new ArrayList<Integer>(temp);
        newTemp.add(current);
        sumUnique(candidates, result, index + 1, currentSum + current, target, newTemp);

        while (++index < candidates.length && candidates[index] == current) {
            continue;
        }
        sumUnique(candidates, result, index, currentSum, target, new ArrayList<Integer>(temp));
    }
}
