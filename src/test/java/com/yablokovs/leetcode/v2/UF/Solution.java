package com.yablokovs.leetcode.v2.UF;

class Solution {
    char[] parent;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int l = s1.length();
        parent = new char[26];
        for (int i = 0; i < 26; i++) { // a -> 0
            parent[i] = (char) ('a' + i);
        }
        // System.out.println('a' - 0);
        // System.out.println('z' - 0);

        // c -> a
        // d -> b
        // e -> c -> a

        for (int i = 0; i < l; i++ ) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            char pa = getParent(a); // a
            char pb = getParent(b); // c
            if (pa > pb) {
                parent[pa - 'a'] = pb;
            } else if (pa < pb) {
                parent[pb - 'a'] = pa;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (char c : baseStr.toCharArray()) {
            sb.append(getParent(c));
        }

        return sb.toString();
    }

    private char getParent(char c) {
        if (c == parent[c - 'a']) return c;
        return getParent(parent[c - 'a']);
    }
}