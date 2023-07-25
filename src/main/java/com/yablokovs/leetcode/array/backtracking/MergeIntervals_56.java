package com.yablokovs.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparing((array) -> array[0], Integer::compare));
        List<int []> newIntervals = new ArrayList<>();
        int [] current = intervals[0];

        // 13 24
        for(int i = 1; i < intervals.length; i++) {
            int [] next = intervals[i];

            if(current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                newIntervals.add(current);
                current = next;
            }
        }
        newIntervals.add(current);

//        int[][] res = new int[newIntervals.size()][2];
//        for(int i = 0; i < newIntervals.size(); i++) {
//            res[i] = newIntervals.get(i);
//        }
//        return res;

        return newIntervals.toArray(new int[newIntervals.size()][]);
    }
}
