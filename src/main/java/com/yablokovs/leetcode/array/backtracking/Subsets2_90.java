package com.yablokovs.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsets2_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (Integer n : nums) {
            counts.compute(n, (k, v) -> v == null ? 1 : v + 1);
        }
        // List<Integer> keys = new ArrayList<>(counts.keySet());
        // Set<Integer> keySet = counts.keySet();
        // List<Integer> keys = new ArrayList<>():
        // for(Integer i : keySet) {
        //     keys.add(i);
        // }
        List<List<Integer>> result = new ArrayList<>();
        sub(new ArrayList<Integer>(), result, counts);
        return result;
    }

    private void sub(List<Integer> temp, List<List<Integer>> result, Map<Integer, Integer> map) {
        if (map.isEmpty()) {
            result.add(temp);
            return;
        }
        Integer key = -1;
        Integer count = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            key = e.getKey();
            count = e.getValue();
            break;
        }
        map.remove(key);

        sub(new ArrayList<>(temp), result, new HashMap<>(map));

        List<Integer> full = new ArrayList<>(temp);
        for (int i = 0; i < count; i++) {
            full.add(key);
            sub(new ArrayList<>(full), result, new HashMap<>(map));
        }
    }
}
