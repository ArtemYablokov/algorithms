package com.yablokovs.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CheapestFlightsWithinKStops {
    public int cheapestFlightsWithinKStops(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>(); // from to

        for (int[] arr : flights) {
            map.compute(arr[0], (key, v) -> {
                if (v == null) {
                    Map<Integer, Integer> temp = new HashMap<>();
                    temp.put(arr[1], arr[2]);
                    return temp;
                } else {
                    v.put(arr[1], arr[2]);
                    return v;
                }
            });
        }
        List<int[]> dfs = dfs(src, map, -1, 0, k, dst, new HashMap<>(), new HashSet<>());
        if (dfs == null || dfs.size() == 0)
            return -1;

        int min = Integer.MAX_VALUE;
        for (int[] arr : dfs) {
            if (arr[0] <= k) {
                min = Math.min(arr[1], min);
            }
        }

        return min;
    }


    private List<int[]> dfs(int node, Map<Integer, Map<Integer, Integer>> map, int counter, int price, int limit, int dst, HashMap<Integer, ArrayList<int[]>> calculated, Set<Integer> visited) {
        if (counter > limit)
            return null;

        if (node == dst) {
            ArrayList<int[]> temp = new ArrayList<>();
            temp.add(new int[]{-1, 0});
            return temp;
        }

        // 6 sec
//        if (visited.contains(node)) {
//            return null;
//        }

        // Out Of Memory
        if (visited.contains(node)) {
            return calculated.getOrDefault(node, null);
        }


        Map<Integer, Integer> childs = map.get(node);
        if (childs == null)
            return null;

        visited.add(node);

        ArrayList<int[]> objects = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : childs.entrySet()) {
            List<int[]> dfs = dfs(e.getKey(), map, counter + 1, e.getValue(), limit, dst, calculated, visited);
            if (dfs == null)
                continue;

            for (int[] arr : dfs) {
                int[] ints = {arr[0] + 1, arr[1] + e.getValue()};
                objects.add(ints);
            }

        }
        if (objects.size() == 0)
            objects = null;

        calculated.put(node, objects);
//        visited.remove(node);

        return objects;
    }

}
