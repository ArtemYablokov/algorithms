package com.yablokovs.leetcode.v2.bs;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfRemovableCharacters_1898 {
    char[] sa;
    char[] pa;

    public int maximumRemovals(String s, String p, int[] removable) {
        int l = removable.length;
        int i = 0;
        int j = l - 1;
        sa = s.toCharArray();
        pa = p.toCharArray();
        Set<Integer> set;
        while (i <= j) {
            int m = (i + j) / 2;
            set = new HashSet<>();
            for (int k = 0; k <= m; k++)
                set.add(removable[k]);

            boolean b = check(set);
            if (b)
                i = m + 1;
            else
                j = m - 1;
        }
        return 1 + j;
    }

    private boolean check(Set<Integer> set) {
        if (set.size() + pa.length > sa.length)
            return false;
        int i = 0;
        int j = 0;
        while (j < pa.length && i < sa.length) {
            if (set.contains(i)) {
                i++;
                continue;
            }

            if (sa[i] == pa[j])
                j++;
            i++;
        }
        if (j == pa.length)
            return true;

        return false;
    }

}
