package com.yablokovs.LC_v3.SW;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LengthOfTheLongestValidSubstring_2781_HARD {

    Trie root = new Trie();

    public int longestValidSubstring(String word, List<String> forbidden) {
        forbidden.sort(Comparator.comparingInt(String::length));
        forbidden.forEach(this::addToTrie);

        char[] a = word.toCharArray();
        int l = a.length;
        int[] LAST = new int[l];

        Arrays.fill(LAST, -1); // means that for each end available start

        for (int i = 0; i < l; i++) {
            int length = getLength(i, a);
            if (length != -1) {
                LAST[i + length] = i; // cur ix is a start for this end
            }
            // check what the word match is
            // -> set this length to LAST
        }

        // after getting index - got through all
        // inside this span - check for : a) shortest b) earliest -
        // earliest can use - to define length with previous available start
        // WRONG approach!
        // mark a start and the end of each encountered word

        int start = -1;
        int res = 0;

        for (int end = 0; end < l; end++) {
            int tempStart = LAST[end];
            if (tempStart > start) start = tempStart;

            int diff = end - start;
            // for 1 letter start will be == end -> diff == 0
            // it considers that start shouldn't be included - for 1 letter diff == 0
            if (diff > res) res = diff;
        }


        return res;
    }


    // ERROR
    // if node == null - return -1
    // if node is word - return counter

    int getLength(int ix, char[] a) {
        Trie node = root;
        int counter = -1; // -1 will mean 0 match at all?

        while (ix < a.length && node.nodes[a[ix] - 'a'] != null) {
            counter++;
            node = node.nodes[a[ix] - 'a'];
            if (node.word) break;
            ix++;
        }
        return counter;
    }

    public void addToTrie(String w) {
        Trie node = root;
        int ix = 0;
        while (ix < w.length()) {
            char cur = w.charAt(ix);
            var next = node.nodes[cur - 'a'];
            if (next != null && next.word) break;
            if (next == null) {
                next = new Trie();
                node.nodes[cur - 'a'] = next;
            }
            node = next;
            ix++;
        }
        node.word = true;
    }

    public static class Trie {
        Trie[] nodes = new Trie[26];
        boolean word;
    }

}

