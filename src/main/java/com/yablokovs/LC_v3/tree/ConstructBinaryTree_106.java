package com.yablokovs.LC_v3.tree;

import com.yablokovs.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree_106 {
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

    // handle postorder from right to left
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }


        return build(inorder.length - 1, 0, inorder.length - 1, inorder, postorder, map);
    }

    // i, j - inorder
    TreeNode build(int postIx, int i, int j, int[] in, int[] post, Map<Integer, Integer> map) {
        if (i == j)
            return new TreeNode(in[i]);
        if (j < i)
            return null;

        int rootIx = map.get(post[postIx]);


        int leftSize = rootIx - i;
        int rightSize = j - rootIx;

        TreeNode newN = new TreeNode(post[postIx]);

        TreeNode left = build(postIx - rightSize - 1, i, rootIx - 1, in, post, map);
        TreeNode right = build(postIx - 1, rootIx + 1, j, in, post, map);

        newN.left = left;
        newN.right = right;

        return newN;
    }
}
