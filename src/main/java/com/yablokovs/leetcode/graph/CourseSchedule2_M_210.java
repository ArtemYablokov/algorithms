package com.yablokovs.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule2_M_210 {


    public static void main(String[] args) {

        int[] order = findOrder(5, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 3}, {3, 4}/*, {4, 2}*/});
        int n = 0;

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> contains = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for (int[] pair : prerequisites) {
            int key = pair[0];
            int value = pair[1];
            map.compute(key, (k, v) -> {
                if (v == null) {
                    return new ArrayList<>(List.of(value));
                } else {
                    v.add(value);
                    return v;
                }
            });
        }
        for (int i = 0; i < numCourses; i++) {
            map.putIfAbsent(i, null);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!method(map, i, visited, output, contains))
                return new int[]{};
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean method(Map<Integer, List<Integer>> map, int index, Set<Integer> visited, List<Integer> output, Set<Integer> containsOutput) {
        if (containsOutput.contains(index))
            return true;

        if (visited.contains(index))
            return false;

        visited.add(index);

        List<Integer> integers = map.get(index);
        if (integers == null) {
            output.add(index);
            containsOutput.add(index);
            return true;
        }
        for (Integer integer : integers) {
            if (!method(map, integer, visited, output, containsOutput))
                return false;
        }
        output.add(index);
        containsOutput.add(index);
        return true;
    }
}
