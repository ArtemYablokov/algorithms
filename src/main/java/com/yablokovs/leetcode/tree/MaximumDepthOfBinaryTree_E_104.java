package com.yablokovs.leetcode.tree;

public class MaximumDepthOfBinaryTree_E_104 {

    public int maxDepth(TreeNode root) {
        if (root != null) {
            return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
        return 0;
    }
}
