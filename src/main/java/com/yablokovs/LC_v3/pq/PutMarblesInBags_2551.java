package com.yablokovs.LC_v3.pq;

import java.util.PriorityQueue;

public class PutMarblesInBags_2551 {
    public long putMarbles(int[] weights, int k) {
        int[] w = weights;
        int l = w.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(w[b] + w[b + 1], w[a] + w[a + 1])
        );

        for (int i = 0; i < l - 1; i++) {
            pq.offer(i);
        }
        long max = w[0] + w[l - 1];
        for (int i = 0; i < k - 1; i++) {
            int left = pq.poll();
            max += w[left];
            max += w[left + 1];
        }

        pq = new PriorityQueue<>(
                (b, a) -> Integer.compare(w[b] + w[b + 1], w[a] + w[a + 1])
        );

        for (int i = 0; i < l - 1; i++) {
            pq.offer(i);
        }
        long min = w[0] + w[l - 1];
        for (int i = 0; i < k - 1; i++) {
            int left = pq.poll();
            min += w[left];
            min += w[left + 1];
        }

        return max - min;
    }
}
