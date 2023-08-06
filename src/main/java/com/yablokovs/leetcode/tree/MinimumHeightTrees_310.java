package com.yablokovs.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees_310 {

    public List<Integer> findMinHeightTrees_N2(int n, int[][] edges) {
        if (n == 1)
            return List.of(0);
        Map<Integer, List<Integer>> paths = new HashMap<>();

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            List<Integer> aList = paths.get(a);
            List<Integer> bList = paths.get(b);

            if (aList == null)
                paths.put(a, new ArrayList<>(List.of(b)));
            else
                aList.add(b);

            if (bList == null)
                paths.put(b, new ArrayList<>(List.of(a)));
            else
                bList.add(a);
        }

        Map<Integer, Integer> nodeToDepth = new HashMap<>();
        int maxLength = 0;
        for (Map.Entry<Integer, List<Integer>> e : paths.entrySet()) {
            List<Integer> children = e.getValue();

            int currLength = 0;
            for (Integer c : children) {
                int temp = getDepth(paths, nodeToDepth, c, e.getKey()) + 1;

                currLength = Math.max(temp, currLength);
            }
            nodeToDepth.put(e.getKey(), currLength);

            maxLength = Math.max(maxLength, currLength);
        }

        int half = maxLength / 2;
        boolean even = maxLength % 2 == 0;
        if (!even)
            half += 1;

        List<Integer> result = new ArrayList<>();

//        if (even) {
        for (Map.Entry<Integer, Integer> e : nodeToDepth.entrySet()) {
            if (e.getValue() == half) {
                result.add(e.getKey());
//                break;
            }
        }
//        } else {
//            for (Map.Entry<Integer, Integer> e : nodeToDepth.entrySet()) {
//                if (e.getValue() == half || e.getValue() == half + 1) {
//                    result.add(e.getKey());
//                }
//            }
//        }
        return result;
    }

    private int getDepth(Map<Integer, List<Integer>> paths, Map<Integer, Integer> nodeToDepth, Integer current, Integer parent) {

        List<Integer> children = paths.get(current);

        if (children.size() == 1) { // LEAF
//            nodeToDepth.put(current, 0);
            return 0;
        }

        int curDepth = 0;

        for (Integer child : children) {
            if (child.equals(parent))
                continue;

            int childDepth = getDepth(paths, nodeToDepth, child, current);

            if (curDepth < childDepth)
                curDepth = childDepth;
        }

//        nodeToDepth.put(current, curDepth + 1);
        return curDepth + 1;
    }


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {

            map.compute(edge[0], (k, v) -> {
                if (v == null)
                    return new HashSet<>(List.of(edge[1]));
                v.add(edge[1]);
                return v;
            });

            map.compute(edge[1], (k, v) -> {
                if (v == null)
                    return new HashSet<>(List.of(edge[0]));
                v.add(edge[0]);
                return v;
            });

        }

        while (map.size() > 2) {

            List<Integer> leaves = new ArrayList<>();

            for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
                if (e.getValue().size() == 1)
                    leaves.add(e.getKey());
            }

            for (int leaf : leaves) {
                Set<Integer> parentsChildren = map.get(map.get(leaf).iterator().next());
                parentsChildren.remove(leaf);
                map.remove(leaf);
            }
            leaves.clear();
        }

        return map.keySet().stream().toList();
    }
}
