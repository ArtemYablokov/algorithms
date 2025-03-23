package com.yablokovs.leetcode.HARD;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConcatenatedWords {
    List<String> result = new ArrayList<>();
    Node root = new Node('!');
    String[] w;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        w = words;
        Arrays.sort(w, Comparator.comparingInt(String::length));
        for (String s : w) {
            if (dfs(root, s.toCharArray(), 0))
                result.add(s);
            else
                add(s.toCharArray());
        }
        return result;
    }

    private boolean dfs(Node n, char[] s, int ix) {
        if (ix > s.length) return false;
        char cur = s[ix];
        if (n.nodes[cur - 'a'] == null)
            return false;

        n = n.nodes[cur - 'a'];
        if (n.isWord) {
            if (ix == s.length - 1) return true;
            boolean b = dfs(root, s, ix + 1);
            if (b)
                return true;
        }
        return dfs(n, s, ix + 1);
    }

    private void add(char[] s) {
        Node n = root;
        int ix = 0;

        while (ix < s.length) {
            char cur = s[ix];

            if (n.nodes[cur - 'a'] == null) {
                Node newN = new Node(cur);
                n.nodes[cur - 'a'] = newN;
                n = newN;
            } else
                n = n.nodes[cur - 'a'];
            ix++;
        }
        n.isWord = true;
    }

    @ToString(exclude = "nodes")
    class Node {
        char c;
        Node[] nodes = new Node[26];
        boolean isWord;

        public Node(char c) {
            this.c = c;
        }
    }
}
