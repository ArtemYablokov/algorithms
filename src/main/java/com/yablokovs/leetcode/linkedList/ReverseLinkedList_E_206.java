package com.yablokovs.leetcode.linkedList;

public class ReverseLinkedList_E_206 {

    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }

    public ListNode reverseListRecursive(ListNode head) {
        return recursive(head, null);
    }

    private ListNode recursive(ListNode current, ListNode previous) {

        if (current == null) {

            return previous;
        }
        if (current.next == null) {
            current.next = previous;
            return current;
        } else {
            ListNode next = current.next;

            current.next = previous;
            previous = current;
            current = next;

            return recursive(current, previous);
        }
    }
}
