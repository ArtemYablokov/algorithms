package com.yablokovs.LC_v3.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination_1976 {
    int MOD = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {
        if (n == 1) return 1;
        List<int[]>[] adj = new ArrayList[n];
        for (int[] r : roads) {
            if (adj[r[0]] == null)
                adj[r[0]] = new ArrayList<>();
            adj[r[0]].add(new int[]{r[1], r[2]});

            if (adj[r[1]] == null)
                adj[r[1]] = new ArrayList<>();
            adj[r[1]].add(new int[]{r[0], r[2]});
        }
        int[][] dp = new int[n][]; // TIME to NUMBER
        dp[0] = new int[]{0, 1};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // time to ix
        pq.offer(new int[]{0, 0});

        // i should add to PQ
        // only when dp == null
        // if it's not null - just handle time and number

        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int ix = cur[1];
            int time = dp[cur[1]][0];


            if (cur[0] > time) {
                continue;
            }

            int number = dp[ix][1];

            List<int[]> list = adj[ix];
            for (int[] l : list) {
                int next = l[0];
                int nextTime = l[1];
                if (dp[next] == null) { // first visit
                    dp[next] = new int[]{time + nextTime, number};
                    pq.offer(new int[]{time + nextTime, next});
                } else { // already visited
                    if (dp[next][0] > time + nextTime) { // reset to better time
                        dp[next][0] = time + nextTime;
                        dp[next][1] = number;

                        pq.offer(new int[]{time + nextTime, next}); // leads to DUPLICATES but all of them will have diff time? yes
                    } else if (dp[next][0] == time + nextTime) { // accumulate numbers for same time
                        dp[next][1] += number;
                        dp[next][1] %= MOD;
                    }
                }
                // ignore when time is smaller
            }
        }
        return dp[n - 1][1]; //
    }

    public int countPathsTLE(int n, int[][] roads) {
        List<int[]>[] adj = new ArrayList[n];
        for (int[] r : roads) {
            if (adj[r[0]] == null)
                adj[r[0]] = new ArrayList<>();
            adj[r[0]].add(r);

            if (adj[r[1]] == null)
                adj[r[1]] = new ArrayList<>();
            adj[r[1]].add(new int[]{-1, r[0], r[2]});
        }
        int[][] timeNumber = new int[n][];
        // timeNumber[0] = new int[]{0, 1}; // one way to reach in 0 time

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // [ix, time]
        pq.offer(new int[]{0, 0});
        while (pq.size() > 0) {
            int[] ixTime = pq.poll();
            int t = ixTime[1];
            int ix = ixTime[0];
            if (timeNumber[ix] == null) { // first reach
                timeNumber[ix] = new int[]{t, 1};
            } else {
                if (timeNumber[ix][0] == t) {
                    timeNumber[ix][1]++; // increase number
                } else if (timeNumber[ix][0] > t) { // reset time
                    timeNumber[ix][0] = t;
                    timeNumber[ix][1] = 1;
                } else { // timeNumber[ix][0] < t
                    continue;
                }
            }

            List<int[]> list = adj[ix];
            // if (list != null) // graph is connected
            for (int[] l : list) {
                pq.offer(new int[]{l[1], t + l[2]});
            }
        }

        return timeNumber[n - 1][1];
    }
}
