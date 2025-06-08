package com.yablokovs.LC_v3.tree;

import com.yablokovs.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static com.yablokovs.LC_v3.util.Util.build;
import static org.junit.jupiter.api.Assertions.*;

class ConstructBinaryTree_106Test {

    @Test
    void buildTree() {
        ConstructBinaryTree_106 constructBinaryTree106 = new ConstructBinaryTree_106();

        TreeNode treeNode = constructBinaryTree106.buildTree(build(9, 3, 15, 20, 7), build(9, 15, 7, 20, 3));

    }
}