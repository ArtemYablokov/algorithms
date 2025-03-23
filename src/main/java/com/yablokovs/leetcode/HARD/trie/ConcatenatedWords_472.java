package com.yablokovs.leetcode.HARD.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ConcatenatedWords_472 {
    Node root = new Node();
    char a = 'a';

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // Arrays.sort(words);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(words));

        List<String> result = new ArrayList<>();

        for (String s : words) {
            boolean concatenated = checkWord(root, s, 0);
            if (!concatenated)
                addWord(s);
            else
                result.add(s);
        }
        return result;
    }

    private void addWord(String word) {
        int l = word.length();
        int ix = 0;
        Node node = root;
        while (ix < l) {
            if (node.chars[word.charAt(ix) - a] != null) {
                node = node.chars[word.charAt(ix) - a];
            } else {
                Node newN = new Node();
                node.chars[word.charAt(ix) - a] = newN;
                node = newN;
            }
            ix++;
        }
        node.isWord = true;
    }

    public int minMeetingRooms(int[][] intervals) {
        int[][] arr = intervals;
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int l = arr.length;
        int result = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] a : arr) {
            while (!pq.isEmpty() && pq.peek()[1] <= a[0])
                pq.poll();
            pq.offer(a);
            if (pq.size() > result) result = pq.size();
        }

        return result;
    }


    private boolean checkWord(Node node, String word, int ix) {
        node = node.chars[word.charAt(ix) - a];
        if (node == null)
            return false;

        if (node.isWord) {
            if (ix == word.length() - 1)
                return true;
            boolean b = checkWord(root, word, ix + 1);
            if (b)
                return true;
        }

        if (ix == word.length() - 1)
            return false;
        return checkWord(node, word, ix + 1);


        // if (node != null) {
        //     boolean b = false;
        //     if (node.isWord) {
        //         if (ix == word.length() - 1) return true;
        //         b = checkWord(root.chars[word.charAt(ix + 1) - a], word, ix + 1);
        //     }
        //     return b || checkWord(node.chars[word.charAt(ix + 1) - a], word, ix + 1);
        // } else {
        //     return false;
        // }
    }

    // FIRST attempt without DP
    // TLE for large set of words (1150 ms for 8th case)

    // SECOND - MEMO for each handling word
    // TLE for same case - large set of words (1090 ms for 8th case) so DP here doesn't help a lot
    // looks like it happens because of
    // here, herl, herm, hern, hero, hers, herb, herd
    // 3 first letters check for each word, while it's only last letter change

    // THIRD - try TRIE without memo, just TRIE

    class Node {
        // char ch;
        Node[] chars = new Node[26];
        boolean isWord;
        // public Node(char ch) {
        //     this.ch = ch;
        // }
    }


// do we need DP here to define that from that point of word we've already tried
// and we shouldn't try again ?
// i suppoze yes because there also could be case like:
// a
// aa
// aaa
// and word aaaz
// which means that we can reach same point with different ways

}
