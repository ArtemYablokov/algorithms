package com.yablokovs.leetcode.v2.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeDiameter_1245 {

    public int treeDiameter(int[][] edges) {
        int v = edges.length + 1;
        if (v == 1) return 0;
        if (v == 2) return 1;
        List<Integer>[] tree = new List[v];
        int[] counter = new int[v];

        for (int i = 0; i < v; i++)
            tree[i] = new ArrayList<>();

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            counter[e[0]]++;
            tree[e[1]].add(e[0]);
            counter[e[1]]++;
        }

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (counter[i] == 1)
                q.offer(i);
        }
        char c = ' ';

        int size;
        int result = 0;
        while ((size = q.size()) > 1) {
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                // counter[cur] = 0;
                for (int t : tree[cur]) {
                    counter[t]--;
                    if (counter[t] == 1) {
                        q.offer(t);
                    }
                }
            }
            result += 2;
        }
        return result;
    }

}
