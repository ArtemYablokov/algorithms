package com.yablokovs.LC_v3.prefix;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs_2352 {


    Node root = new Node();


    public int equalPairs(int[][] grid) {
        int h = grid.length;
        int l = grid[0].length;

        for (int i = 0; i < h; i++) {
            int[] row = grid[i];

            Node cur = root;

            for (int j = 0; j < l; j++) {
                Node next = cur.map.get(row[j]);
                if (next == null) {
                    next = new Node();
                    cur.map.put(row[j], next);
                }
                cur = next;
            }
            cur.counter++;
        }

        int res = 0;
        for (int j = 0; j < l; j++) {
            // int[] row = grid[i];
            Node cur = root;
            int i = 0;
            while (i < h) {
                Node next = cur.map.get(grid[i][j]);
                if (next == null) {
                    break;
                }
                cur = next;
                i++;
            }
            if (i == h) {
                res += cur.counter;
            }
        }

        return res;
    }


    class Node {
        Map<Integer, Node> map = new HashMap<>();
        int counter = 0;

    }


}
