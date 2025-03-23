package com.yablokovs.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {

    int[] res;
    List<int[]>[] map;

    public int networkDelayTime(int[][] times, int n, int k) {
        map = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

//        Arrays.fill(map, new ArrayList<>());
        res = new int[n + 1];
        Arrays.fill(res, -1);

        for (int[] a : times) {
            map[a[0]].add(a);
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        q.offer(new int[]{k, 0});
        int size;

        while ((size = q.size()) > 0) {

            int[] cur = q.poll();
            int key = cur[0];
            if (res[key] == -1 || res[key] > cur[1]) {
                res[key] = cur[1];

                List<int[]> childs = map[key];
                for (int[] child : childs) {
                    q.offer(new int[]{child[1], cur[1] + child[2]});
                }
            }

        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            int num = res[i];
            if (num == -1)
                return -1;
            if (num > max)
                max = num;
        }
        return max;
    }

}

