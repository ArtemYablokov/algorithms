package com.yablokovs.leetcode.linkedList;

public class SortedListToLinkedList {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    public TreeNode build(ListNode head, ListNode tail) {
        if (head == null)
            return null;
        if (head == tail)
            return new TreeNode(head.val); // tail != null &&

//        System.out.println(head.val);
//        System.out.println(tail == null ? "null" : tail.val);


        ListNode start = head;

        ListNode mid = head;
        ListNode end = head;

        while (end != null && end != tail) {
            end = end.next;
            if (end == null || end.next == tail)
                break;

            end = end.next;
            mid = mid.next;

        }
        // System.out.println(head.val);
        // System.out.println(mid.val);
        // System.out.println(end);

        TreeNode m = new TreeNode(mid.val);

        if (start != mid)
            m.left = build(start, mid);

        m.right = build(mid.next, end); // end == null always

        return m;
    }
}
