package com.yablokovs.LC_v3.mono;

import java.util.Arrays;
import java.util.LinkedList;

public class JumpGameVIII_2297 {
    public long minCost(int[] nums, int[] costs) {
        int l = nums.length;
        if (l == 1) return costs[0];
        LinkedList<Integer> s = new LinkedList<>(); // mono Incr

        int[] maxJump = new int[l];

        for (int i = 0; i < l; i++) {
            int val = nums[i];
            while (!s.isEmpty() && nums[s.peek()] <= val) {
                maxJump[s.pop()] = i;
            }
            s.push(i);
        }

        s = new LinkedList<>(); // mono Decr
        int[] minJump = new int[l];
        for (int i = 0; i < l; i++) {
            int val = nums[i];
            while (!s.isEmpty() && nums[s.peek()] > val) {
                minJump[s.pop()] = i;
            }
            s.push(i);
        }

        long[] dp = new long[l];
        Arrays.fill(dp, -1L);
        dp[l - 1] = costs[l - 1];

        long bt = bt(dp, 0, minJump, maxJump, costs);

        return bt - costs[0];
    }

    long bt(long[] dp, int ix, int[] minJump, int[] maxJump, int[] cost) {
        if (dp[ix] != -1) return dp[ix];

        long min = Long.MAX_VALUE; // not reachable - shouldn't be
        if (minJump[ix] != 0) {
            min = bt(dp, minJump[ix], minJump, maxJump, cost);
        }

        if (maxJump[ix] != 0) {
            long t = bt(dp, maxJump[ix], minJump, maxJump, cost);
            if (t < min) min = t;
        }

        dp[ix] = min + cost[ix];
        return dp[ix];
    }

}
