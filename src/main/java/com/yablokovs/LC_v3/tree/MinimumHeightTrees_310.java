package com.yablokovs.LC_v3.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees_310 {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer>[] adj = new ArrayList[n];
//            Arrays.fill(adj, new ArrayList<>());
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            int[] count = new int[n];

            if (edges.length == 0) return List.of(0);

            for (int[] e : edges) {
                adj[e[0]].add(e[1]);
                adj[e[1]].add(e[0]);
                count[e[0]]++;
                count[e[1]]++;
                // System.out.println(Arrays.toString(count));
            }
            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                if (count[i] == 1) {
                    // System.out.printf("added i = %d", i);
                    q.offer(i);
                }
            }
            // System.out.println(Arrays.toString(count));
            // i got ADJACENCY
            // i want remove number of link from node.
            // there will left 1 link -> i'm going there
            // from this node i shouldn't go back

            int size;
            while (n > 2) {
                size = q.size();
                // List<Integer> temp = new ArrayList<>(q);
                // for (int s = 0; s < size; s++) System.out.println(temp.get(s));
                // System.out.println();
                // System.out.println(Arrays.toString(count));
                for (int s = 0; s < size; s++) {
                    int cur = q.poll();
                    List<Integer> list = adj[cur];
                    for (int l : list) {
                        // List<Integer> next = adj[l];
                        // if (next == null) continue; // ignore handled nodes
                        count[l]--;
                        if (count[l] == 1) q.offer(l);
                    }
                    // adj[cur] = null;
                    n--;
                    count[cur]--;
                }
            }

            List<Integer> result = new ArrayList<>(q);
            return result;
        }
}
