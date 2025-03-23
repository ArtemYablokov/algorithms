package com.yablokovs.leetcode.linkedList;


import lombok.ToString;

@ToString(exclude = "next")
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}
