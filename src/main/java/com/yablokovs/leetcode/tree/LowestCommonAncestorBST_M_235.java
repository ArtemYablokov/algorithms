package com.yablokovs.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBST_M_235 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pNodes = getPath(root, p, new ArrayList<>());
        List<TreeNode> qNodes = getPath(root, q, new ArrayList<>());

        TreeNode common = null;

        int pSize = pNodes.size();
        int qSize = qNodes.size();

        int i = 0;

        while (i < pSize && i < qSize) {
            TreeNode pi = pNodes.get(i);
            TreeNode qi = qNodes.get(i);
            if (pi.val != qi.val) {
                break;
            }
            common = pi;
            i++;
        }

        return common;
    }

    private List<TreeNode> getPath(TreeNode current, TreeNode node, List<TreeNode> path) {
        if (current == null)
            return null;

        path.add(current);

        List<TreeNode> leftPath = null;
        List<TreeNode> rightPath = null;

        if (current.val == node.val) {
            return path;
        } else {
            leftPath = getPath(current.left, node, createCopy(path));
            rightPath = getPath(current.right, node, createCopy(path));
        }

        return leftPath != null ? leftPath : rightPath;
    }

    private List<TreeNode> createCopy(List<TreeNode> source) {
        List<TreeNode> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null; // exit

        if (root.val == p.val)
            return p; // found
        if (root.val == q.val)
            return q;

        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        if (leftTree != null && rightTree != null)
            return root;

        if (leftTree != null)
            return leftTree;
        if (rightTree != null)
            return rightTree;

        return null;
    }
}
