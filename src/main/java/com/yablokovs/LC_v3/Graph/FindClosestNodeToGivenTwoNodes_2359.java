package com.yablokovs.LC_v3.Graph;

import java.util.Arrays;

public class FindClosestNodeToGivenTwoNodes_2359 {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            int n = edges.length;
            int[] a = new int[n];
            Arrays.fill(a, -1);

            int i1 = node1, i2 = node2;
            int counter = 0;
            while (true) {
                if (a[i1] != -1) break;
                a[i1] = counter++;
                if (edges[i1] == -1 || edges[i1] == node1 ) break;
                i1 = edges[i1];
            }

            // System.out.println(Arrays.toString(a));

            counter = 0;

            // int[] b = new int[n];
            // Arrays.fill(b, -1);
            // while (true) {
            //     if (b[i2] != -1) break;
            //     b[i2] = counter++;
            //     if (edges[i2] == -1 || edges[i2] == node2 ) break;
            //     i2 = edges[i2];
            // }
            // System.out.println(Arrays.toString(b));


            int min = Integer.MAX_VALUE;
            int result = -1;
            // for (int i = 0; i < n; i++) {
            //     if (a[i] == -1 || b[i] == -1) continue;
            //     if (Math.max(a[i], b[i]) < min) {
            //         min = Math.max(a[i], b[i]);
            //         result = i;
            //     }
            // }
            while (true) {
                // if (a[i2] == -1) continue; // not reachable from 1st
                if (a[i2] != -1 && Math.max(counter, a[i2]) <= min) {
                    min = Math.max(counter, a[i2]);
                    result = i2;
                }
                if (edges[i2] == -1 || edges[i2] == node2 ) break; // || a[i2] == 0
                // a[i2] = 0;
                int t = i2;
                i2 = edges[i2];
                edges[t] = -1;
                counter++;
                // System.out.println(2);
                // i1 = edges[i1];
            }

            return result;
        }

}
