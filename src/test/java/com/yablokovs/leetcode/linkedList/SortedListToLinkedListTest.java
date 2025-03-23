package com.yablokovs.leetcode.linkedList;

import com.yablokovs.UtilBuildList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedListToLinkedListTest {

    @Test
    void sortedListToBST() {

        ListNode listNode = UtilBuildList.buildList(new int[]{-10, -3, 0, 5, 9});

        SortedListToLinkedList sortedListToLinkedList = new SortedListToLinkedList();
        TreeNode treeNode = sortedListToLinkedList.sortedListToBST(listNode);

    }
}