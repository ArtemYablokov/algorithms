package com.yablokovs.leetcode.tree;

public class BalancedBinaryTree_E_110 {


    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getDepth(root) != -1;
        }


        private int getDepth(TreeNode root) {

            int left = 0;
            int right = 0;
            boolean b;

            if (root.left != null) {
                left = getDepth(root.left);
            }
            if (root.right != null) {
                right = getDepth(root.right);
            }
            if (right == -1 || left == -1) return -1;

            if (Math.abs(right - left) > 1) return -1;

            return Math.max(right, left) + 1;
        }
    }
}
