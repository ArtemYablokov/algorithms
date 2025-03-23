package com.yablokovs.leetcode.HARD.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordBreak2 {

//    D8tinJwHyGQxsiQWTXYHBAOC3avniIQI
    List<List<String>> result = new ArrayList<>();

    Map<Integer, Integer> map = new HashMap<>();



    Node root = new Node('!');

    public List<String> wordBreak(String s, List<String> wordDict) {
        map.put(1, 5);
        map.put(2, 2);
        map.put(3, 1);
        map.put(4, 6);

        List<Integer> integers = map.entrySet().stream().map(Map.Entry::getValue).sorted(Comparator.reverseOrder()).limit(2).toList();
//        Collections.sort(wordDict, Comparator.comparingInt(String::length));

        for (String str : wordDict)
            add(str.toCharArray());

        dfs(s.toCharArray(), 0, root, new ArrayList<>());

        return result.stream()
                .map(list ->
                        list.stream().collect(Collectors.joining(" "))
                ).toList();
    }

    private boolean dfs(char[] s, int ix, Node n, List<String> list) {
        if (ix > s.length - 1)
            return false;
        char cur = s[ix];

        Node next = n.nodes[cur - 'a'];
        if (next == null)
            return false;

        if (next.word != null) { // is word
            if (ix == s.length - 1) {
                list.add(next.word);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return true;
            }
            list.add(next.word);
            dfs(s, ix + 1, root, list);
            list.remove(list.size() - 1);
            // if (b) return true;
        }
        return dfs(s, ix + 1, next, list);
    }

    private void add(char[] s) {
        Node n = root;
        int ix = 0;
        while (ix < s.length) {
            char cur = s[ix];
            Node next = n.nodes[cur - 'a'];
            if (next == null) {
                Node newN = new Node(cur);
                n.nodes[cur - 'a'] = newN;
                n = newN;
            } else {
                n = next;
            }
            ix++;
        }
        n.word = new String(s);
    }


    class Node {
        char c;
        String word;
        Node[] nodes = new Node[26];

        public Node(char c) {
            this.c = c;
        }
    }
}
