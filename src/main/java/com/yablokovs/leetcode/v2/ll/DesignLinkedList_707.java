package com.yablokovs.leetcode.v2.ll;

import lombok.ToString;

public class DesignLinkedList_707 {
    Node head;
    int size = 0;



    public int get(int index) {
        if (index > size - 1)
            return -1;
        int ix = 0;
        Node cur = head;
        while (ix < index) {
            cur = cur.next;
            ix++;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        Node n = new Node(val, head);
        head = n;

        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }

        int ix = 1;
        Node cur = head;
        while (ix < size) {
            cur = cur.next;
            ix++;
        }
        cur.next = new Node(val, null);

        size++;
    }

    // 0 1 2

    public void addAtIndex(int index, int val) {
        if (index > size - 1)
            return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        int ix = 1;
        Node cur = head;
        while (ix < index) {
            cur = cur.next;
            ix++;
        }
        Node last = cur.next;
        cur.next = new Node(val, last);

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index > size - 1)
            return;

        if (index == 0) {
            head = head.next;
            return;
        }

        int ix = 1;
        Node cur = head;
        while (ix < index) {
            cur = cur.next;
            ix++;
        }
        cur.next = cur.next.next;
        size--;
    }

    @ToString
    class Node {
        int val;
        Node next;

        public Node(
                int val,
                Node next
        ) {
            this.val = val;
            this.next = next;
        }

        public Node(
                int val
        ) {
            this.val = val;
        }
    }


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
