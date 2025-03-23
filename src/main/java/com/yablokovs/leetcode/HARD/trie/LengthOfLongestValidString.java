package com.yablokovs.leetcode.HARD.trie;


import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LengthOfLongestValidString {
    Node root = new Node('.');

    public int longestValidSubstring(String word, List<String> forbidden) {
        int start = -1;
        int max = 0;
        char[] arr = word.toCharArray();
        Queue<Node> q = new LinkedList<>();
        // q.offer(root);

        for (String s : forbidden) {
            addToTree(s);
        }

        for (int i = 0; i < arr.length; i++ ) {
            boolean end = false;

            int curChar = arr[i] - 'a';

            Node curN = root.nodes[ curChar ];
            if (curN != null && curN.isWord) { // single-letter word
                q = new LinkedList<>();
                start = i;
                continue;
            }

            int size;
            if ((size = q.size()) > 0) {

                for (int j = 0; j < size; j++) {
                    Node t = q.poll();

                    Node cur = t.nodes[ curChar ];
                    if (cur == null) continue;

                    if (cur.isWord) {
                        end = true;
                        start = i - cur.l + 1;
                    } else {
                        if ( !end ) q.offer( cur ); // i < arr.length - 1 &&
                    }
                }
            }
            if (end) {
                q = new LinkedList<>();
                i = start; // move start to
            } else if (curN != null)
                q.offer(curN);

            if (i - start > max) max = i - start;
        }

        return max;
    }

    private void addToTree(String word) {
        char[] arr = word.toCharArray();
        int i = 0;

        Node next = root;
        while (i < arr.length) {
            Node cur = next.nodes[arr[i] - 'a'];
            if (cur == null) {
                cur = new Node(arr[i]);
                next.nodes[arr[i] - 'a'] = cur;
            }
            next = cur;
            i++;
        }
        next.isWord = true;
        next.l = arr.length;
    }

    @ToString(exclude = {"l", "nodes"})
    class Node {
        char c;
        int l;
        Node[] nodes = new Node[26];
        boolean isWord = false;

        public Node (char c) {
            this.c = c;
        }
    }
}