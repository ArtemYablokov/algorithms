package com.yablokovs.LC_v3.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestDivisibleSubset_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> dp = new HashMap<>();

        // for (int n : nums) set.add(n);
        Arrays.sort(nums);

        int l = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> t = dfs(i, set, dp, nums);
            if (t.size() > l) {
                l = t.size();
                list = t;
            }
            set.add(nums[i]);
        }

        return list;
    }

    List<Integer> dfs(int ix, Set<Integer> set, Map<Integer, List<Integer>> dp, int[] nums) {
        if (dp.containsKey(ix))
            return dp.get(ix);

        int n = nums[ix];
        int l = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = ix - 1; i >= 0; i--) {

            int next = nums[i];
            // go one direction only
            if (n % next == 0) { //  || next > n && next % n == 0
                List<Integer> t = dfs(i, set, dp, nums);
                if (t.size() > l) {
                    l = t.size();
                    list = new ArrayList<>(t);
                }
                break;
            }
        }
        list.add(n);
        dp.put(n, list);
        return list;
    }

}
