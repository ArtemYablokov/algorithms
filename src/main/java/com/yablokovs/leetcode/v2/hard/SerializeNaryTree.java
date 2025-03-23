package com.yablokovs.leetcode.v2.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeNaryTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {

        // for (Node c : root.children) {
        //     System.out.println("c.val = " + c.val);
        //     System.out.println("c.ch = " + c.children);
        // }

        System.out.println(build(root));
        return build(root);
    }

    private String build(Node root) {
        // System.out.println("root.val = " + root.val);
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(root.val);
        sb.append(" ");

        if (root.children.size() == 0) return sb.toString();

        sb.append("[");
        for (Node n : root.children) {
            sb.append( build(n) );
            sb.append(" ");
        }

        sb.append("]");
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(data);
        sb.append(" ]");
        String[] arr = sb.toString().split("\\s+");

//        System.out.println(Arrays.toString(arr));

//        int root = Integer.parseInt(arr[1]);

        List<Node> temp = new ArrayList<>();
        parseString(arr, 0, temp);

        return temp.get(0);
    }

    private int parseString(String[] arr, int ix, List<Node> parentList) {
        // " 1 [ 3 [ 5   6  ]  2   4  ]"
        ix++; // = skip opening [

        while (ix < arr.length && !"]".equals(arr[ix]) ) {
            int cur = Integer.parseInt(arr[ix++]);
            Node newN = new Node(cur);
            if ("[".equals(arr[ix])) {
                List<Node> temp = new ArrayList<>();
                ix = parseString(arr, ix, temp);
                newN.children = temp;
            }
            parentList.add(newN);
        }

        return ++ix;

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", children=" + children +
                    '}';
        }
    }
}
