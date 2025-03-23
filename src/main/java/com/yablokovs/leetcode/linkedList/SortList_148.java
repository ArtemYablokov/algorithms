package com.yablokovs.leetcode.linkedList;

public class SortList_148 {

    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;

        ListNode _0 = new ListNode(0);
        _0.next = head;

        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }

        ListNode prev1;
        ListNode _1;
        for (int range = 1; range < counter; range *= 2) {
            prev1 = _0;
            _1 = _0.next;

            while (_1 != null) {

                // TODO: 9/14/23  1 SETUP SECOND POINTER
                ListNode _2 = _1;
                ListNode prev2 = prev1;

                int cycle = range;
                while (_2 != null && cycle > 0) {
                    prev2 = _2;
                    _2 = _2.next;
                    cycle--;
                }

                // TODO: 9/14/23  2 MERGE
                int start = range;
                int end = range;
                while (start > 0 && end > 0) {
                    if (_2 == null)
                        break;

                    if (_1.val < _2.val) {
                        start--;
                        prev1 = _1;
                        _1 = _1.next;
                    } else {
                        end--;
                        ListNode temp = _2;

                        prev2.next = _2.next;
                        _2 = _2.next;

                        prev1.next = temp;
                        prev1 = temp;
                        prev1.next = _1;

                    }

                }
                // if (_2 == null) continue;

                // TODO: 9/14/23  3 MOVE START POINTER TO NEW START
                for (int i = 0; i < start + end; i++) {
                    if (_1 == null) {
                        int n = 0;
                    }
                    prev1 = _1;
                    _1 = _1.next;
                }

            }
        }

        return _0.next;
    }

}
