package com.yablokovs.leetcode.linkedList;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/submissions/929768167/
 *
 * это подход с 2мя указателями - указывающий на центр передвигается вдвое реже
 *
 * так же можно исаользовать стек и спуститься в него на половину (или нужное значение шагов)
 *
 * */


public class MiddleOfTheLinkedList_E_876 {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {

            ListNode middle = head;
            boolean skip = true;
            int size = 1;

            while (head.next != null) {

                if (!skip) {
                    middle = middle.next;
                }
                head = head.next;

                size++;
                skip = !skip;
            }

            if (size % 2 == 0) {
                middle = middle.next;
            }


            return middle;
        }
    }
}
