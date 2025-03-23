package com.yablokovs.LC_v3.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended2_1751 {

    int sum = 0;
    int end = 0;

    public int maxValue(int[][] events, int k) {
        // need to handle PQ of events that can't be handled now, but can in future
        // on top - earliest END

        // PQ of k-1 size (since k-th is currebt one) events by value (smallest on the top)
        // also maintain SUM of k-events

        // sort by start
        int l = events.length;

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        // System.out.println(Arrays.toString(events));

        int[][] ends = Arrays.copyOf(events, l);
        Arrays.sort(ends, (a, b) -> Integer.compare(a[1], b[1]));
        // Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        // PriorityQueue<int[]> hold = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> valid = new PriorityQueue<>(); // smallest on Top
        int result = 0;
        for (int i = 0; i < l; i++) {
            int[] cur = events[i];
            int start = cur[0];
            // while (!hold.isEmpty() && hold.peek()[1] < start) {
            //     int[] earliest = hold.poll();
            //     offer(valid, earliest[2], k);
            // }
            offer(valid, i, ends, events, k);
            if (sum + cur[2] > result)
                result = sum + cur[2];

            // hold.offer(cur);
        }

        return result;
    }

    private void offer(PriorityQueue<Integer> valid, int cur, int[][] ends, int[][] events, int k) {
        if (k == 1)
            return;
        while (end < cur && ends[end][1] < events[cur][0]) {
            int other = ends[end][2];
            if (valid.size() < k - 1) {
                sum += other;
                valid.offer(other);
            } else {
                if (valid.peek() < other) {
                    sum -= valid.poll();
                    sum += other;
                    valid.offer(other);
                }
            }
            end++;
        }
    }
}
