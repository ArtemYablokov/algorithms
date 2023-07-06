package com.yablokovs.leetcode.dp.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum_M_39 {

    // 2, 3, 5 -> 8

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int matrixLength = target + 1;
        List<List<Integer>>[] matrix = new List[matrixLength]; // List<List> = one Column for each 0-target
        for (int i = 0; i < matrixLength; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int c : candidates) {
            for (int i = 0; i < matrixLength; i++) {
                int diff = i - c;
                if (diff == 0) {
                    matrix[i].add(List.of(c));
                }
                if (diff > 0) {
                    for (List<Integer> sets : matrix[diff]) {
                        List<Integer> integers = new ArrayList<>(sets);
                        integers.add(c);
                        matrix[i].add(integers);
                    }
                }
            }
        }

        return matrix[target];
    }
}
