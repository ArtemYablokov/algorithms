package com.yablokovs.leetcode.array.two_dim;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_M_57 {
    public static void main(String[] args) {

        // TODO: 4/23/23  new - standard
//        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
//        int[] newInterval = {4, 8};

        // TODO: 4/23/23 empty
//        int[][] intervals = {};
//        int[] newInterval = {2, 7};


        // TODO: 4/23/23  new - AFTER
//        int[][] intervals = {{1, 3}};
//        int[] newInterval = {5, 7};

        // TODO: 4/23/23  new - BEFORE
//        int[][] intervals = {{5, 7}};
//        int[] newInterval = {1, 3};

        // TODO: 4/23/23  new - INSIDE
//        int[][] intervals = {{1, 7}};
//        int[] newInterval = {2, 3};

        // TODO: 4/23/23  new - OUTSIDE
        int[][] intervals = {{2, 3}};
        int[] newInterval = {1, 7};




        insert(intervals, newInterval);

    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int numOfRaw = intervals.length;

        int raw = 0;
        while (raw < numOfRaw && intervals[raw][1] < newStart) {
            output.add(intervals[raw]);
            raw++;
        }
        if (raw == numOfRaw) {
            output.add(new int[]{newStart, newEnd});
            return getResult(output);
        }

        if (intervals[raw][0] < newStart) newStart = intervals[raw][0];

        while (raw < numOfRaw && intervals[raw][1] < newEnd) {
            raw++;
        }

        if (raw == numOfRaw) {
            output.add(new int[]{newStart, newEnd});
            return getResult(output);
        }

        // если не вышел за конец:
        if (intervals[raw][0] > newEnd) {
            output.add(new int[]{newStart, newEnd});
            output.add(intervals[raw]);
        } else {
            if (intervals[raw][1] > newEnd) newEnd = intervals[raw][1];
            output.add(new int[]{newStart, newEnd});
        }

        // TODO: 4/22/23 remaining:
        for (raw++; raw < numOfRaw; raw++) {
            output.add(intervals[raw]);
        }
        return getResult(output);
    }

    private static int[][] getResult(List<int[]> output) {
        int[][] result = new int[output.size()][2];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    public static int[][] insertFalse(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int raw;

        int numOfRaw = intervals.length;
        if (numOfRaw == 0) return new int[][]{newInterval};

        for (raw = 0; raw < numOfRaw; raw++) {
            if (intervals[raw][1] < newStart) {
                output.add(intervals[raw]);
                continue;
            }
            if (intervals[raw][0] < newStart) newStart = intervals[raw][0];
            break;
        }

        for (; raw < numOfRaw; raw++) {
            if (intervals[raw][1] < newEnd) {
                if (raw == numOfRaw - 1) {
                    output.add(new int[]{newStart, newEnd});
                    raw++;
                    break;
                }
                continue;
            }
            if (intervals[raw][0] > newEnd) {
                output.add(new int[]{newStart, newEnd});
                break;
            }
            if (intervals[raw][1] > newEnd) newEnd = intervals[raw][1];
            output.add(new int[]{newStart, newEnd});
            raw++;
            break;
        }

        for (; raw < numOfRaw; raw++) {
            output.add(intervals[raw]);
        }
        int[][] result = getResult(output);
        return result;
    }
}
