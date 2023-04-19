package com.yablokovs.leetcode.tree;

public class DiameterOfBinaryTree_E_543 {

    private static int counter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        counter = 0;
        getDeep(root);
        return counter;
    }

    private int getDeep(TreeNode root){
        if (root.left == null && root.right == null) return 0;

        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = getDeep(root.left);
            left++;
        }
        if (root.right != null) {
            right = getDeep(root.right);
            right++;
        }
        counter = Math.max(counter, right + left);
        return Math.max(left, right);
    }
}
