package com.yablokovs.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        permute(s, result, new ArrayList<>());
        return result;
    }

    private void permute(String s, List<List<String>> result, List<String> current) {
        if (s.length() == 0) {
            result.add(current);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.toCharArray(), 0, i)) {
                ArrayList<String> temp = new ArrayList<>(current);
                temp.add(s.substring(0, i + 1));
                permute(s.substring(i + 1), result, temp);
            }
        }
    }

    private boolean isPalindrome(char[] charSequence, int start, int end) {
        while (start < end) {
            if (charSequence[start] != charSequence[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}
