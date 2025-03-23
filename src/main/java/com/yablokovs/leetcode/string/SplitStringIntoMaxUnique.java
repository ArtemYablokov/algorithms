package com.yablokovs.leetcode.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SplitStringIntoMaxUnique {
    public int maxUniqueSplitBT(String s) {
        return dfs(s, new HashSet<>());
    }

    private int dfs(String s, Set<String> set) {
        if (s.length() == 0)
            return 0;
        int res = Integer.MIN_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (set.add(sub)) {
                res = Math.max(res, dfs(s.substring(i), set) + 1);
                set.remove(sub);
            }
        }
        return res;
    }

    HashSet<String> uniques;
    String s;
    int max;

    public int maxUniqueSplit(String s) {
        this.s = s;
        uniques = new HashSet<>();
        helper(0, 0);
        return max;
    }

    private void helper(int start, int count) {
        if (start == s.length()) {
            max = Math.max(max, count);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int end = start; end < s.length(); end++) {
            // count + 1 + (s.length() - 1) - (end + 1) + 1
            if (max >= count + s.length() - end)
                break;
            sb.append(s.charAt(end));
            String sub = sb.toString();
            if (uniques.contains(sub))
                continue;
            uniques.add(sub);
            helper(end + 1, count + 1);
            uniques.remove(sub);
        }
    }
}
