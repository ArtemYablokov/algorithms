package com.yablokovs.leetcode.tree;

/*
* https://leetcode.com/problems/same-tree/
*
* interesting solution with Deque and Queue
*
* */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    public static void main(String[] args) {

        String input = String.valueOf(0);
    }

    public boolean isSameTreeQueue(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        if (p != null && q != null) {
            queue.offer(p);
            queue.offer(q);
        }
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null)
                continue;
            if (first == null || second == null)
                return false;
            if (first.val != second.val)
                return false;
            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);
        }
        return true;
    }

    public boolean isSameTreeDeque(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();

            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;

            queue.add(p.left);
            queue.add(q.left);
            queue.add(p.right);
            queue.add(q.right);
        }
        return true;
    }


    private boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}


