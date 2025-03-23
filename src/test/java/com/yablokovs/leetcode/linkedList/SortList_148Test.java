package com.yablokovs.leetcode.linkedList;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SortList_148Test {

    @Test
    void sortList() {
        SortList_148 sortList148 = new SortList_148();

        ListNode listNode = generateList(new int[]{-1, 5, 3});

        ListNode listNode1 = sortList148.sortList(listNode);

        int n = 0;


    }


    private ListNode generateList(int[] arr) {
        List<ListNode> listNodes = Arrays.stream(arr)
                .boxed()
                .map(ListNode::new)
                .toList();

        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }

        return listNodes.get(0);
    }
}