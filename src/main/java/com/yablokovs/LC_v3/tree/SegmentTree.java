package com.yablokovs.LC_v3.tree;

public class SegmentTree {
// Utility method to print the segment tree in a tree-like structure
    public void printTree() {
        printTreeHelper(1, 0, n - 1, 0);
    }

    private void printTreeHelper(int node, int l, int r, int depth) {
        if (l > r || node >= tree.length) return;
        for (int i = 0; i < depth; i++) System.out.print("    ");
        System.out.println("[" + l + "," + r + "]: " + tree[node] + (lazy[node] != 0 ? " (lazy=" + lazy[node] + ")" : ""));
        if (l == r) return;
        int mid = (l + r) / 2;
        printTreeHelper(2 * node, l, mid, depth + 1);
        printTreeHelper(2 * node + 1, mid + 1, r, depth + 1);
    }
    int[] tree;
        int[] lazy;
        int n;

        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new int[ n * 3];
            lazy = new int[n * 3];
            build(nums, 1, 0, n - 1);
        }

        public void build(int[] nums, int node, int l, int r) {
            if (l == r) {
                tree[node] = nums[l];
                return;
            }
            int mid = (l + r) / 2;
            build(nums, 2 * node, l, mid);
            build(nums, 2 * node + 1, mid + 1, r);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        public void push(int node, int l, int r) {
            if (lazy[node] != 0) {
                tree[node] += (r - l + 1) * lazy[node];
                if (l != r) {
                    lazy[2 * node] += lazy[node];
                    lazy[2 * node + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }

        // Range update: add val to all elements in [ul, ur]
        public void update(int ul, int ur, int val) {
            update(1, 0, n - 1, ul, ur, val);
        }

        public void update(int node, int l, int r, int ul, int ur, int val) {
            push(node, l, r);

            if (r < ul || l > ur) return;
            // If the current segment is completely within the update range
            if (ul <= l && r <= ur) {
                lazy[node] += val;
                push(node, l, r); // can't remove it
                return;
            }

            int mid = (l + r) / 2;
            update(2 * node, l, mid, ul, ur, val);
            update(2 * node + 1, mid + 1, r, ul, ur, val);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        // Range query: sum in [ql, qr]
        public int query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        public int query(int node, int l, int r, int ql, int qr) {
            push(node, l, r);
            if (r < ql || l > qr) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            return query(2 * node, l, mid, ql, qr) +
                   query(2 * node + 1, mid + 1, r, ql, qr);
        }

}
