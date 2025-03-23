package com.yablokovs.LC_v3.SuffixArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumLengthOfRepeatedSubarray_718 {
    public int findLength(int[] nums1, int[] nums2) {
//        System.out.println((char) 800);
        String[] s1 = build(nums1);
        String[] s2 = build(nums2);

        int i = 0, j = 0;
        int result = 0;
        while (i < s1.length && j < s2.length) {
            int max = max(s1[i], s2[j]);
            if (max > result)
                result = max;
            int compare = s1[i].compareTo(s2[j]);
            if (compare < 0)
                i++;
            else if (compare > 0)
                j++;
            else {
                i++;
                j++;
            }
        }

        return result;
    }

    int max(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return i;
    }

    String[] build(int[] a) {
        StringBuilder sb = new StringBuilder();
        String[] result = new String[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            sb.insert(0, ((char) a[i]));
            result[i] = sb.toString();
        }
        Arrays.sort(result);
        return result;
    }

    class Tree {
        boolean end;
        Map<Integer, Tree> map = new HashMap<>();
    }

    Tree root = new Tree();

    public int findLength_Trie(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            add(nums1, i);
        }
        int result = 0;
        for (int i = 0; i < nums2.length; i++) {
            int check = check(nums2, i);
            if (check > result) result = check;
        }
        return result;
    }

    void add(int[] a, int ix) {
        Tree t = root;
        while (ix < a.length) {
            if (t.map.containsKey(a[ix])) {
                t = t.map.get(a[ix]);
            } else {
                Tree temp = new Tree();
                t.map.put(a[ix], temp);
                t = temp;
            }
            ix++;
        }
        t.end = true;
    }

    int check(int[] a, int ix) {
        int result = 0;
        Tree t = root;
        while (ix < a.length && t != null) {
            Tree temp = t.map.get(a[ix]);
            if (temp != null) {
                result++;
            }
            t = temp;
            ix++;
        }
        return result;
    }
}


