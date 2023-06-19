package com.yablokovs.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal_M_102 {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rleft = new TreeNode(15);
        TreeNode rright = new TreeNode(7);
        right.left = rleft;
        right.right = rright;


        TreeNode node = new TreeNode(3);
        node.left = left;
        node.right = right;

        List<List<Integer>> lists = levelOrder(node);

        int n = 0;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        if (root != null) {
            treeNodes.offer(root);
        }

        while (!treeNodes.isEmpty()) {
            int queueSize = treeNodes.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode poll = treeNodes.poll();
                putInQueueChildren(poll, treeNodes);
                temp.add(poll.val);
            }
            output.add(temp);
        }
        return output;
    }

    private static void putInQueueChildren(TreeNode node, Queue queue) {
        TreeNode left = node.left;
        if (left != null)
            queue.offer(left);
        TreeNode right = node.right;
        if (right != null)
            queue.offer(right);
    }


    private static void putInStackChildren(TreeNode node, Stackie stackie) {
        TreeNode left = node.left;
        if (left != null)
            stackie.putToStack(left);
        TreeNode right = node.right;
        if (right != null)
            stackie.putToStack(right);
    }

    private static class Stackie {
        List<TreeNode> holder = new ArrayList<>();
        int pointer = -1;

        public boolean stackNotEmpty() {
            return pointer > -1;
        }

        public void putToStack(TreeNode value) {
            holder.add(++pointer, value);
        }

        public List<TreeNode> getAllFromStack() {
            ArrayList<TreeNode> integers = new ArrayList<>(holder);
            pointer = -1;
            holder.clear();
            return integers;
        }
    }




}
