package com.yablokovs.leetcode.HARD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenatedWordsDP {
    String[] w;
    List<String> result = new ArrayList<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        w = words;
        Arrays.sort(w, (a, b) -> Integer.compare(a.length(), b.length()));

        for (String s : w) {
            if (dfs(s, 0))
                result.add(s);
        }
        return result;
    }

    private boolean dfs(String word, int ix) {
        System.out.println(ix);
        if (ix == word.length())
            return true;

        for (String s : w) {
            if (s.equals(word))
                continue;
            if (ix + s.length() > word.length())
                break;

            if (word.startsWith(s, ix)) {
                if (dfs(word, ix + s.length()))
                    return true;
            }
        }
        return false;
    }

// a
// az
// aaz
}
