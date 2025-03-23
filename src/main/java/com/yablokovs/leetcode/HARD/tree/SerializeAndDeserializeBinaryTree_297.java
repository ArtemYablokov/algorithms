package com.yablokovs.leetcode.HARD.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_297 {

    public String serialize(TreeNode root) { // LATER build List<Integer> and remove last N-s
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        int size = q.size();
        while(size > 0) {
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current == null) {
                    sb.append("N,");
                    continue;
                }
                sb.append(current.val);
                sb.append(",");

                q.offer(current.left);
                q.offer(current.right);

            }
            size = q.size();
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        List<Integer> integers = deserializeToList(data);

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        int index = 0;
        TreeNode node = new TreeNode(integers.get(index));
        q.offer(node);
        index++;


        int size = q.size();
        while (size > 0 && index < integers.size()) {
            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                Integer a = integers.get(index++); // 1
                if(a != null) {
                    current.left = new TreeNode(a);
                    q.offer(current.left);
                }
                if (index ==  integers.size()) break;
                Integer b = integers.get(index++); // 2
                if(b != null) {
                    current.right = new TreeNode(b);
                    q.offer(current.right);
                }
            }
            size = q.size();
        }
        return node;
    }


    private List<Integer> deserializeToList(String string) {
        String[] split = string.split(",");
        return Arrays.stream(split).map( s -> {
                    if(s.equals("N")) return null;
                    return Integer.parseInt(s);
                }
        ).toList();
    }
}
