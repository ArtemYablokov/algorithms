package com.yablokovs.leetcode.v2.graph;

import java.util.PriorityQueue;
import java.util.Random;

class Prim {
    public int minCostConnectPoints(int[][] points) {
        int l = points.length;

        Random random = new Random();
        int i1 = random.nextInt(1,9);

        boolean[] visited = new boolean[l];

        // visited[0] = true;
        int result = 0;

        // point(as index) to distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        // to pq adding only not visited yet
        pq.offer(new int[]{0, 0});

        // exit case - number of components
        int n = l;
        while (n > 0) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            result += cur[1];
            visited[cur[0]] = true;

            for (int i = 0; i < l; i++) {
                if (!visited[i]) {
                    pq.offer(new int[] {
                            i,
                            Math.abs(points[i][0] - points[cur[0]][0]) + Math.abs(points[i][1] - points[cur[0]][1])
                    });
                }
            }
            n--;
        }

        return result;
    }
}
