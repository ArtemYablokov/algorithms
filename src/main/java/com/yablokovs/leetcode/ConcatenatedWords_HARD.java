package com.yablokovs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class ConcatenatedWords_HARD {

    Node root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Node(',');
        Arrays.sort(words, Comparator.comparing(s -> s.length()));

        // System.out.println(Arrays.toString(words));
        List<String> result = new ArrayList<>();
        Set<String> notReach = new HashSet<>();
        for (String w : words) {
            boolean b = dfs(root, 0, w, notReach);
            if (b)
                result.add(w);
            add(root, 0, w.toCharArray());
            // System.out.println( root.map.get('c').c );
        }

        return result;
    }

    private boolean dfs(Node node, int i, String w, Set<String> notReach) {
        String temp = w.substring(i, w.length());

        if (notReach.contains(temp))
            return false;

        if (i == w.length()) {
            if (node == root)
                return true;
            return false;
        }

        Node cur = node.map.get(w.charAt(i));
        if (cur == null) {
            return false;
        }
        // System.out.println(w[i]);
        boolean notW = dfs(cur, i + 1, w, notReach);
        if (notW) return true;

        if (cur.isWord) {

            boolean isW = dfs(root, i + 1, w, notReach);
            if (isW)
                return true;
                // TODO: 11/2/23
//            else {
//                notReach.add(w.substring(i + 1));
//            }

        }


        return false;
    }

    private boolean add(Node root, int i, char[] w) {
        if (i == w.length)
            return true;

        Node cur = root.map.get(w[i]);
        if (cur == null) {
            Node _new = new Node(w[i]);
            root.map.put(w[i], _new);
            if (add(_new, i + 1, w)) {
                _new.isWord = true;
            }

        } else {
            if (add(cur, i + 1, w))
                cur.isWord = true;
        }
        return false;
    }

    class Node {
        char c;
        boolean isWord;
        Map<Character, Node> map = new HashMap<>();

        public Node(char c) {
            this.c = c;
        }
    }

    public List<String> findAllConcatenatedWordsInADictDP(String[] words) {

        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        Set<String> concatenated = new HashSet<>();
        Set<String> reachable = new HashSet<>();

        for (int j = 0; j < words.length; j++) {

            String s = words[j];

            for (int i = 0; i < j; i++) {

                if (s.startsWith(words[i])) {

                    boolean b = reachable(s.substring(words[i].length()), set, reachable, words, j);
                    if (b) {
                        reachable.add(s);
                        concatenated.add(s);
                        break;
                    }
                }
            }

        }
        return concatenated.stream().toList();

    }

    private boolean reachable(String s, Set<String> set, Set<String> reachable, String[] words, int index) {
        if (set.contains(s) || reachable.contains(s))
            return true;

        for (int i = 0; i < index; i++) {

            if (s.startsWith(words[i])) {

                boolean b = reachable(s.substring(words[i].length()), set, reachable, words, index);
                if (b) {
                    reachable.add(s);
                    return true;
                }
            }
        }
        return false;
    }
}
