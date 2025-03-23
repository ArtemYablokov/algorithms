package com.yablokovs.LC_v3.trie;

public class FindTheLengthOfTheLongestCommonPrefix_3043 {
    class Tree {
        Tree[] map = new Tree[10];
    }

    Tree root = new Tree();

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        int l1 = arr1.length;
        int l2 = arr2.length;
        String[] a1 = new String[l1];
        String[] a2 = new String[l2];
        for (int i = 0; i < l1; i++)
            a1[i] = String.valueOf(arr1[i]);
        for (int i = 0; i < l2; i++)
            a2[i] = String.valueOf(arr2[i]);

        for (int i = 0; i < l1; i++) {
            add(a1[i]);
        }

        int result = 0;
        for (int i = 0; i < l2; i++) {
            int check = check(a2[i]);
            if (check > result)
                result = check;
        }
        return result;
    }

    void add(String s) {
        int ix = 0;

        Tree t = root;
        while (ix < s.length()) {
            int i = s.charAt(ix) - '0';
            if (t.map[i] != null) {
                t = t.map[i];
            } else {
                Tree temp = new Tree();
                t.map[i] = temp;
                t = temp;
            }
            ix++;
        }
    }

    int check(String s) {
        int result = 0;
        Tree t = root;
        int ix = 0;
        while (ix < s.length() && t != null) {
            int i = s.charAt(ix) - '0';
            Tree temp = t.map[i];
            if (temp != null) {
                result++;
            }
            t = temp;
            ix++;
        }
        return result;
    }
}
