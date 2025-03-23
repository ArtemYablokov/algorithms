package com.yablokovs.leetcode.v2.sw;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinimumAbsoluteDifference_2187 {

    int min = Integer.MAX_VALUE;


    public int minAbsoluteDifference(List<Integer> nums, int x) {

        TreeSet<Integer> set = new TreeSet<>();
        Integer floor = set.floor(0);
        Integer ceiling = set.ceiling(0);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = nums.size();
        for (int i = l - 1; i >= x ; i--) {
            int cur = nums.get(i);
            map.compute(cur, (k, v) -> v == null ? 1 : v + 1);
        }


        for (int i = 0; i < l - x; i++) {
            int cur = nums.get(i);

            Integer top = map.ceilingKey(cur);
            if (top != null)
                min = Math.min(Math.abs(top - cur), min);

            Integer bottom = map.floorKey(cur);
            if (bottom != null)
                min = Math.min(Math.abs(bottom - cur), min);
//            if (i - x + 1 >= 0)
//                map.compute(nums.get(i - x + 1), (k, v) -> v == null ? 1 : v + 1);

            int next = nums.get(i + x);
            map.compute(next, (k, v) -> v == 1 ? null : v - 1);
        }

        return min;
    }
}
