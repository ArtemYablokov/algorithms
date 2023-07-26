package com.yablokovs.leetcode.array.backtracking;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Node n = new Node(' ');

        for (String w : wordDict) {
            Node currentNode = n;
            Node lastNode = currentNode;

            for (Character c : w.toCharArray()) {
                TreeMap<Character, Node> childrenMap = currentNode.map;

                if (childrenMap == null) {
                    TreeMap<Character, Node> newMap = new TreeMap<>();
                    Node newNode = new Node(c);
                    newMap.put(c, newNode);
                    currentNode.map = newMap;
                    currentNode = newNode;
                } else {
                    Node childNode = childrenMap.get(c);
                    if (childNode == null) {
                        Node newNode = new Node(c);
                        childrenMap.put(c, newNode);
                        currentNode = newNode;
                    } else {
                        currentNode = childNode;
                    }
                }
                lastNode = currentNode;
            }
            lastNode.isWord = true;

        }

        return checkString(s.toCharArray(), 0, n, n);
    }

    private boolean checkString(char[] chars, int index, Node currentNode, Node map) {
        if (index == chars.length)
            return false;

        char curr = chars[index];

        Node childNode;
        TreeMap<Character, Node> children;
        if ((children = currentNode.map) != null && (childNode = children.get(curr)) != null) {
            if (checkString(chars, index + 1, childNode, map))
                return true;
            if (childNode.isWord) { // конец слова
                if (index == chars.length - 1)
                    return true;
                if (checkString(chars, index + 1, map, map))
                    return true; // запускаем поиск дальше с коренной мапой
            }
            // не конец - ищем дальше
        }
        return false;
    }


    private class Node /*implements Comparable<Node> */ {
        Character c;
        boolean isWord;
        TreeMap<Character, Node> map;

        public Node(Character c) {
            this.c = c;
        }

//        @Override
//        public int compareTo(Node n) {
//            return Integer.compare(this.c, n.c);
//        }
//
//        @Override
//        public boolean equals(Object n) {
//            Node nn = (Node) n;
//            return nn.c.equals(this.c);
//        }

    }


    public boolean wordBreak2(String s, Set<String> dict) {
        if (s == null || s.length() == 0)
            return false;
        int n = s.length();
        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }


    // for each word in dict:
//     if current index of s starts with word:
//         increment index to word length and recurse until end of word, returning true
// else nothing found to work so return false

    public boolean wordBreak3(String s, List<String> wordDict) {
        byte[] dp = new byte[s.length()];    // dp[i] = if possible to use words from wordDict to make s up to index i
        Arrays.fill(dp, (byte) -1);          // initialize all to -1 to indicate not calculated yet

        return wordBreak(s, 0, wordDict, dp);
    }

    private boolean wordBreak(String s, int index, List<String> dictionary, byte[] bool) {
        if (index == s.length()) // previous word finished at last INDEX -> string completed
            return true;

        if (bool[index] == 0) // can't reach end from this index
            return false;

        for (int i = 0; i < dictionary.size(); i++) { // FOR EACH WORD
            String word = dictionary.get(i);

            // if the word starts at index,
            if (!s.startsWith(word, index))
                continue;

            // move to index after word
            if (wordBreak(s, index + word.length(), dictionary, bool)) { // can get to the end
                return true;
            }
        }

        bool[index] = 0; // can't reach end from this index
        return false;
    }

    // for each word in dict:
//     if current index of s starts with word:
//         increment index to word length and recurse until end of word, returning true
// else nothing found to work so return false

    class SolutionКриворукого {
        public boolean wordBreak(String s, List<String> wordDict) {
            byte[] dp = new byte[s.length()];    // dp[i] = if possible to use words from wordDict to make s up to index i
            Arrays.fill(dp, (byte) -1);          // initialize all to -1 to indicate not calculated yet

            return wordBreak(s, 0, wordDict, dp);
        }

        private boolean wordBreak(String s, int index, List<String> wordDict, byte[] dp) {
            if (index >= s.length())                  // index past entire string already, means we found a solution
                return true;

            if (dp[index] != -1)
                return dp[index] == 1;               // decision here was using 1 to represent true, and 0 to represent false

            byte match = 0;
            for (int i = 0; i < wordDict.size(); i++) {
                String word = wordDict.get(i);
                if (s.startsWith(word, index) && wordBreak(s, index + word.length(), wordDict, dp)) {    // if the word starts at index, we recursively look for solution down this path
                    match = 1;
                    break;    // found a solution already so can break and skip work
                }
            }

            dp[index] = match;    // save result in dp for future use

            return match == 1;
        }
    }

}
