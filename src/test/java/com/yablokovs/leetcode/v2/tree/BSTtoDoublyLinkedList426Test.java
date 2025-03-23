package com.yablokovs.leetcode.v2.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTtoDoublyLinkedList426Test {

    @Test
    void treeToDoublyList() {
        BSTtoDoublyLinkedList426 bsTtoDoublyLinkedList426 = new BSTtoDoublyLinkedList426();

        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2, node1, node3);
        bsTtoDoublyLinkedList426.treeToDoublyList(node2);
    }
}