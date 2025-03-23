package com.yablokovs.LC_v3.union_find;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence_128 {
    Map<Integer, Integer> size = new HashMap<>();
    Map<Integer, Integer> root = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        for (int n : nums) {
            Integer l = getRoot(n - 1);
            Integer r = getRoot(n + 1);

            Integer c = getRoot(n);
            if (c == null) {
                root.put(n, n);
                size.put(n, 1);
                c = n;
            }
            // merge L and C
            if (l != null && l != c) { // C==L - means C included in L interval
                root.put(c, l);
                size.computeIfPresent(l, (k, v) -> v + 1); // because C can't have > 1 size
            } else {
                l = c; // onsider C as a left interval
            }

            // merge L (C became L if L was null) and R
            if (r != null && r != l) {
                root.put(r, l);
                size.computeIfPresent(l, (k, v) -> v + size.get(r));
            }

        }
        int result = 0;
        for (int v : size.values())
            if (v > result)
                result = v;
        return result;

    }

    Integer getRoot(int n) {
        Integer r = root.get(n);
        if (r == null)
            return null;
        if (r == n)
            return r; // self-root

        return getRoot(r);
    }


}
