package com.yablokovs.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

    Set<String> prev = new HashSet<>();

    int maxLength = 0;
    List<String> result = new ArrayList<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String s : words) {
            boolean b = checkWord(s);
            if (b)
                result.add(s);
            else {
                prev.add(s);
                maxLength = s.length();
            }
        }

        return result;
    }

    private boolean checkWord(String s) {
        char[] array = s.toCharArray();
        int l = s.length();
        boolean[] notreach = new boolean[l];

        return dfs(notreach, array, 0);
    }

    private boolean dfs(boolean[] notreach, char[] array, int ix) {

        int l = array.length;
        if (ix == l)
            return true;
        if (notreach[ix])
            return false;

        StringBuilder sb = new StringBuilder();
        for (int i = ix, j = 0; i < l && j < maxLength; i++, j++) {
            sb.append(array[i]);
            String temp = sb.toString();
            if (prev.contains(temp)) {
                boolean b = dfs(notreach, array, ix + temp.length());
                if (b)
                    return true;
            }
        }

        notreach[ix] = true;
        return false;
    }
}
