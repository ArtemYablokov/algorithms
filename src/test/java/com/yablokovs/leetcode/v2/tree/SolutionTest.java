package com.yablokovs.leetcode.v2.tree;

import com.yablokovs.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void largestBSTSubtree() {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        left.left = new TreeNode(1);
        left.right = new TreeNode(8);

        root.left = left;
        TreeNode right = new TreeNode(15);
//        right.left = new TreeNode(1);
        right.right = new TreeNode(7);
        root.right = right;

        Solution solution = new Solution();
        int i = solution.largestBSTSubtree(root);


    }
}