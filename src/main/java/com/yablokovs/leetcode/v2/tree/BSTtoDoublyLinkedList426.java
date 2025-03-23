package com.yablokovs.leetcode.v2.tree;


public class BSTtoDoublyLinkedList426 {
    Node head = null;
    Node cur = null;
    public Node treeToDoublyList(Node root) {
        // System.out.println(root.left.val);
        // System.out.println(root.left.left.val);
        // System.out.println(root.left.right.val);
        // System.out.println(root.right.val);
        inorder(root);
        head.left = cur;
        cur.right = head;

        return head;
    }

    private void inorder(Node n) {
        if (n == null) return;
        // System.out.println(n.val);
        // if (n.val == 3)
        //     System.out.println(head.val);
//        cur = n;

        if (head == null && n.left == null) {
            head = n;
            cur = n;
            inorder(n.right);
            return;
        }
        inorder(n.left);
        // if (cur != null) { // always will be not null ???
        n.left = cur;
        cur.right = n;
        cur = n;
        // }
        inorder(n.right);
    }
}
