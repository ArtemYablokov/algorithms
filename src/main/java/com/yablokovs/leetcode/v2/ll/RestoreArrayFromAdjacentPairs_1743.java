package com.yablokovs.leetcode.v2.ll;

import java.util.HashMap;
import java.util.Map;

public class RestoreArrayFromAdjacentPairs_1743 {

    Map<Integer, Node> map = new HashMap<>();

    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] a : adjacentPairs) {
            Node n1 = map.get(a[0]);
            Node n2 = map.get(a[1]);
            if (n1 != null && n2 != null) { // link existed Nodes
                if (n1.left == null)
                    n1.left = n2;
                else
                    n1.right = n2;

                if (n2.left == null)
                    n2.left = n1;
                else
                    n2.right = n1;
            } else if (n1 != null) {
                n2 = new Node(a[1]);
                map.put(a[1], n2);
                if (n1.left == null)
                    n1.left = n2;
                else
                    n1.right = n2;
                n2.left = n1;
            } else if (n2 != null) {
                n1 = new Node(a[0]);
                map.put(a[0], n1);
                if (n2.left == null)
                    n2.left = n1;
                else
                    n2.right = n1;
                n1.left = n2;
            } else { // create both
                n1 = new Node(a[0]);
                map.put(a[0], n1);
                n2 = new Node(a[1]);
                map.put(a[1], n2);

                n1.left = n2;
                n2.right = n1;
            }

        }
        Node start = null;
        for (Node n : map.values()) {
            if (n.left == null || n.right == null) {
                start = n;
                break;
            }
        }
        int[] result = new int[adjacentPairs.length + 1];
        Node prev = start;
        int ix = 1;
        // boolean left = start.left != null;
        result[0] = start.val;
        if (start.left == null) start = start.right;
        else start = start.left;

        while (start != null) {
            result[ix++] = start.val;
            if (start.left == null || start.right == null) break;
            Node t = start;
            if ( start.left.val == prev.val) start = start.right; // start.left == null ||
            else start = start.left;

            prev = t;
        }

        return result;
    }

    private static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            String leftS = left == null ? "null" : "" + left.val;
            String rigthS = right == null ? "null" : "" + right.val;
            return "Node{" +
                    "left=" + leftS +
                    ", val=" + val +
                    ", right=" + rigthS +
                    '}';
        }
    }

}
