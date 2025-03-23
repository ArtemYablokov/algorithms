package com.yablokovs.LC_v3.Graph;

import java.util.ArrayList;
import java.util.List;

public class DetonateTheMaximumBombs_2101 {
    int l;
    List<Integer>[] map;
    boolean[] visited;

    //    int[] dp;
    public int maximumDetonation(int[][] bombs) {
        l = bombs.length;
        map = new ArrayList[l];
        visited = new boolean[l];

        for (int i = 0; i < l; i++) {
            double r = bombs[i][2];
            int ix = bombs[i][0];
            int iy = bombs[i][1];
            for (int j = 0; j < l; j++) {
                if (j == i)
                    continue;
                int jx = bombs[j][0];
                int jy = bombs[j][1];
                double dist = Math.sqrt(pow(ix, jx) + pow(iy, jy));
//                System.out.println(i);
//                System.out.println(dist);
//                System.out.println(r);
                if (dist <= r) {
                    if (map[i] == null)
                        map[i] = new ArrayList<>();
                    map[i].add(j);
                    System.out.println(map[i].get(0));
                }
            }
        }
        // System.out.println(map[1].get(0));
        int max = 0;
        for (int i = 0; i < l; i++) {
            int t = dfs(i, visited);
            if (t > max)
                max = t;
        }
        return max;
    }

    double pow(int a, int b) {
        return Math.pow(Math.abs(a - b), 2);
    }

    int dfs(int n, boolean[] visited) {
        if (visited[n])
            return 0;
        visited[n] = true;
        int count = 1; // 1 -> itself

        List<Integer> children = map[n];
        if (children != null) {
            for (int child : children) {
                int t = dfs(child, visited);
                count += t;
            }
        }
//        visited[n] = false;
        return count;
    }

}
