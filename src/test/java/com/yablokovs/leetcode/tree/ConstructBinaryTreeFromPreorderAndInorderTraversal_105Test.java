package com.yablokovs.leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBinaryTreeFromPreorderAndInorderTraversal_105Test {

    @Test
    void buildTree() {
        ConstructBinaryTreeFromPreorderAndInorderTraversal_105 c = new ConstructBinaryTreeFromPreorderAndInorderTraversal_105();

        c.buildTree(new int[]{3,9,1,2,20,15,7}, new int[]{1,9,2,3,15,20,7} );
    }
}