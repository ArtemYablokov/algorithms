package com.yablokovs.leetcode.v2.stack;

import lombok.ToString;

import java.util.LinkedList;

class Solution {
    public String removeDuplicates(String s, int k) {
        LinkedList<Link> dl = new LinkedList<>();

        char[] arr = s.toCharArray();
        char cur = arr[0];
        int count = 1;
        int l = arr.length;
        for (int i = 1; i < l; i++) {
            if (arr[i] == cur) count++;
            else {
                dl.addLast(new Link(cur, count));
                cur = arr[i];
                count = 1;
            }
        }
        dl.addLast(new Link(cur, count));

        int size;

        do {
            size = dl.size();
            Link prev = dl.removeFirst();
            for (int i = 1; i < size; i++) {
                if (prev.count >= k) {
                    int remain = prev.count % k;

                    if (remain > 0) {
                        prev.count = remain;
                        dl.addLast(prev);
                    }
                    continue;
                }

                Link next = null;
                if (i < size - 1 && (next = dl.removeFirst()).c == prev.c   ) {
                    int sum = prev.count + next.count;
                    prev.count = sum;
                    dl.addLast(prev);
                }
                if (next != null) {
                    dl.addLast(prev);
                    prev = next;
                }
            }

        } while (size != dl.size() );

        return "";
    }

    @ToString
    class Link {
        char c;
        int count;

        public Link (
                char c,
                int count
        ) {
            this.c = c;
            this.count = count;
        }
    }
}



// 1 1 2 1 1