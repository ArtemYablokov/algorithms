package com.yablokovs.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule_M_207 {

    // [a, b] - to make a finish b

    public static void main(String[] args) {
        boolean b = canFinish(2, new int[][]{{0, 1}});
        boolean b0 = canFinish(3, new int[][]{});

        boolean b4 = canFinish(3, new int[][]{{0, 2}});
        boolean b1 = canFinish(4, new int[][]{{0, 1}, {1, 2}, {1, 3}, {2, 3}, {3, 4}, {4, 2}});

        int n = 0;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

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
            if (!checkPrereqs(map, i, visited))
                return false;
        }
        return true;
    }

    private static boolean checkPrereqs(Map<Integer, List<Integer>> map, int i, Set<Integer> visited) {
        List<Integer> prereqs = map.get(i);

        if (prereqs == null) {
            visited.add(i);
            return true;
        }
        if (visited.contains(i))
            return false;

        visited.add(i);

        for (Integer integer : prereqs) {
            if (!checkPrereqs(map, integer, visited)) {
                return false;
            }
        }
        map.remove(i);
        return true;
    }

}
