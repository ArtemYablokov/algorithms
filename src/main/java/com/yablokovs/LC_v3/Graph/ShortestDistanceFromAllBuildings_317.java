package com.yablokovs.LC_v3.Graph;

import java.util.LinkedList;

public class ShortestDistanceFromAllBuildings_317 {

    int[][][] a;
    int[][] dp;
    int[][] count;
    int l;
    int h;

    public int shortestDistance(int[][] grid) {
        // System.out.println(a[34][48][1999]);
        l = grid[0].length;
        h = grid.length;
        a = new int[h][l][h * l];
        dp = new int[h][l];
        count = new int[h][l];

        // LinkedList<int[]> q = new LinkedList<>();
        int building = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (grid[i][j] == 1) {
                    bfs(building, new int[]{i, j}, grid);
                    building++;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (grid[i][j] == 0 && count[i][j] == building) {
                    if (dp[i][j] < res)
                        res = dp[i][j];
                }
            }
        }

        return res == Integer.MAX_VALUE || res == 0 ? -1 : res;
    }

    void bfs(int building, int[] init, int[][] grid) {
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{init[0], init[1]});
        int size;
        int step = 1;
        while ((size = q.size()) > 0) {
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                int ix = cur[0];
                int jx = cur[1];

                for (int[] m : moves) {
                    int i = ix + m[0];
                    int j = jx + m[1];
                    if (i < 0 || i == h || j < 0 || j == l || grid[i][j] != 0 || a[i][j][building] != 0) {
                        continue;
                    }
                    a[i][j][building] = step;
                    dp[i][j] += step;
                    count[i][j]++;
                    q.offer(new int[]{i, j});
                }
            }
            step++;
        }
    }

    int[][] moves = new int[][]{
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };


}
