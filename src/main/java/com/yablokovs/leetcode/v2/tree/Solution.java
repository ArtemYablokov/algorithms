package com.yablokovs.leetcode.v2.tree;

import com.yablokovs.leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// 333. Largest BST Subtree
class Solution {
    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }


    private int[] dfs(TreeNode node) { // size min max
        int val = node.val; // 10

        int max = val;
        int min = val;
        int size = 1;

        boolean valid = true;

        TreeNode l = node.left;
        if (l != null) {
            int[] left = dfs(l);
            if (left != null && val > left[2]) {
                // try update max / min / size
                size += left[0];
                min = Math.min(min, left[1]);
                max = Math.max(max, left[2]);
            } else { // not valid
                // if (left[0] > max) max = left[0];
                valid = false;

            }
        }

        TreeNode r = node.right;
        if (r != null) {
            int[] right = dfs(r);
            if (right != null && val < right[1]) {
                // try update max / min / size
                size += right[0];
                min = Math.min(min, right[1]);
                max = Math.max(max, right[2]);
            } else { // not valid
                // if (right[0] > max) max = right[0];
                valid = false;
            }

        }

        if (valid) {
            if (size > this.max)
                this.max = size; // ???
            return new int[]{size, min, max};
        } else
            return null;
    }

}