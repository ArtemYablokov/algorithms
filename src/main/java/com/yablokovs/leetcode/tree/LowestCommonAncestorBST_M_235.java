package com.yablokovs.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            if ( pi.val != qi.val) {
                break;
            }
            common = pi;
            i++;
        }

        return common;
    }

    private List<TreeNode> getPath(TreeNode current, TreeNode node, List<TreeNode> path) {
        if (current == null) return null;

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


    // TODO: 4/10/23
    private List<TreeNode> createCopy(List<TreeNode> source) {
        List<TreeNode> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }
}
