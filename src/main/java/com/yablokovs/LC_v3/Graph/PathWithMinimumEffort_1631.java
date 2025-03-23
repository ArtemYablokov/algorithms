package com.yablokovs.LC_v3.Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort_1631 {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int[][] a;
        int h;
        int l;
        a = heights;
        h = a.length;
        l = a[0].length;

        boolean[][] visited = new boolean[h][l];
        // visited[0][0] = true;

        pq.offer(new int[]{0, 0, 0});
        int max = 0;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            visited[cur[0]][cur[1]] = true;
            int val = a[cur[0]][cur[1]];

            for (int[] m : moves) {
                int i = cur[0] + m[0];
                int j = cur[1] + m[1];
                if (i < 0 || j < 0 || i >= h || j >= l || visited[i][j])
                    continue;
                int t = Math.abs(val - a[i][j]);
                if (t > max)
                    max = t;
                if (i == h - 1 && j == l - 1)
                    return max;
                pq.offer(new int[]{i, j, t});
            }
        }

        return max;
    }

    int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

}
