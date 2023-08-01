package com.yablokovs.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> r = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        bfs(q, r);

        return r;
    }

    private void bfs(Queue<TreeNode> q, List<Integer> r) {
        int size;
        while ((size = q.size()) > 0) {

            for(int i = 0; i < size; i++) {

                TreeNode n = q.poll();

                if(i == 0) r.add(n.val);

                if(n.right != null) q.offer(n.right);

                if(n.left != null) q.offer(n.left);
            }
        }

    }
}
