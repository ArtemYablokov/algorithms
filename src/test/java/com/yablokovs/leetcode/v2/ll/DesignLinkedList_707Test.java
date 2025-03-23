package com.yablokovs.leetcode.v2.ll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesignLinkedList_707Test {

    /*["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
[[],[7],[2],[1],[3,0],[2],[6],[4],[4], [4],[5,0],[6]]*/

    @Test
    void test() {
        // 1 2 7
        DesignLinkedList_707 designLinkedList707 = new DesignLinkedList_707();
        designLinkedList707.addAtHead(7);
        designLinkedList707.addAtHead(2);
        designLinkedList707.addAtHead(1);

        designLinkedList707.addAtIndex(3, 0);
        designLinkedList707.deleteAtIndex(2);

        designLinkedList707.addAtHead(6);
        designLinkedList707.addAtTail(4);
        designLinkedList707.get(4);


    }
}