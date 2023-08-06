package com.yablokovs.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i], i);
        }

        buildNode(preorder, 0, inorder, 0, inorder.length - 1, valueToIndex);

        return null;
    }

    public TreeNode buildNode(int[] preorder, int preIndex, int[] inorder, int inStart, int inFinish, Map<Integer, Integer> valueToIndex) {
        if (inStart > inFinish) return null;
        if (inStart == inFinish) return new TreeNode(inorder[inStart]);


        int current = 0;
        int i;
        for(i = preIndex; i < preorder.length; i++) {

            current = preorder[i];
            if (inStart <= valueToIndex.get(current) && valueToIndex.get(current) <= inFinish) {
                break;
            }
        }
        if (preIndex == preorder.length) return null;

        TreeNode node = new TreeNode();
        node.val = current;

        node.left = buildNode(preorder, preIndex + 1, inorder, inStart, valueToIndex.get(current) - 1, valueToIndex);
        node.right = buildNode(preorder, preIndex + 1, inorder, valueToIndex.get(current) + 1, inFinish, valueToIndex);

        return node;
    }
}
