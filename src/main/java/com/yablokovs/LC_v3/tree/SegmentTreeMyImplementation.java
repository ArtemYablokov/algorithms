package com.yablokovs.LC_v3.tree;

public class SegmentTreeMyImplementation {
    int[] tree;

    public void build(int[] arr) {
        int l = arr.length;
        tree = new int[(l + 1) * 2];

        build(tree, arr, 0, l - 1, 1);

        System.out.println();

    }

    public void query() {
        // This method should implement the query logic
        // For example, to get the sum of a range or a specific index
        // Currently, it is just a placeholder
        System.out.println("Query method not implemented yet.");


    }


    private int build(int[] tree, int[] arr, int l, int r, int ix){
        if (l == r) {
            tree[ix] = arr[l];
            return arr[l];
        }
        int m = (l + r) / 2;

        int left = build(tree, arr, l, m, ix * 2);
        int right = build(tree, arr, m + 1, r, ix * 2 + 1);

        tree[ix] = left + right;
        return tree[ix];
    }

//    private int query(int l, int r, int treeIx, int arrL, int arrR) {
//
//    }

}
