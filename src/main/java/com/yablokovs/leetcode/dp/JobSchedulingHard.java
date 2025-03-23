package com.yablokovs.leetcode.dp;

import java.util.Arrays;

class JobSchedulingHard {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int endIndex = jobs[jobs.length - 1][1];

        int[] max = new int[endIndex + 1];
        int[] dp = new int[endIndex + 1];

        int lastMarkedMAx = 0;

        for (int[] job : jobs) {
            int end = job[1];
            int i;
            for (i = lastMarkedMAx + 1; i < end; i++) {
                max[i] = max[lastMarkedMAx];
            }
            lastMarkedMAx = i - 1;

            int start = job[0];
            int pro = job[2];

            int prev = max[lastMarkedMAx];

            int curProfit = pro + max[start];

            if (prev > curProfit) {
                dp[end] = prev;
            } else {
                dp[end] = curProfit;
                lastMarkedMAx = end;
                max[lastMarkedMAx] = curProfit;
            }

        }

        return dp[dp.length - 1];
    }
}