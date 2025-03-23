package com.yablokovs.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    List<String> result = new ArrayList<>();
    int l;

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        l = n * 2;
        bt(0, sb);
        return result;

    }

    private void bt(int n, StringBuilder sb) {
        if (n < 0) return;
        if (sb.length() == l) {
            if (n == 0)
                result.add(sb.toString());
            return;
        }
        sb.append('(');
        bt(n + 1, sb);
        sb.deleteCharAt(sb.length() - 1);


        sb.append(')');
        bt(n - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
