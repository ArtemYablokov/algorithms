package com.yablokovs;

import com.yablokovs.leetcode.linkedList.ListNode;

public class UtilBuildList {
    public static ListNode buildList(int[] arr) {
        ListNode n = new ListNode(arr[0]);
        ListNode res = n;

        for (int i = 1; i < arr.length; i++) {
            n.next = new ListNode(arr[i]);
            n = n.next;
        }

        return res;
    }
}
