package com.yablokovs.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    Map<Integer, Integer> map = new HashMap<>();

    public int longestConsecutive(int[] nums) {


        for (int n : nums) {
            map.putIfAbsent(n, 1);
        }

        int max = 0;
        for (int n : nums) {
            int t = dfs(n);
            if (t > max)
                max = t;
        }

        return max;
    }


    private int dfs(int n) {
        int cur = n + 1;
        int sum = 0;
        if (!map.containsKey(n) || map.get(n) > 1)
            return 1;

        while (map.containsKey(cur)) {
            int count = map.remove(cur);
            sum += count;
            cur++;
        }

        map.put(n, sum + 1);
        System.out.println("n = " + n);
        System.out.println("sum = " + (sum + 1));
        return sum + 1;
    }
}

