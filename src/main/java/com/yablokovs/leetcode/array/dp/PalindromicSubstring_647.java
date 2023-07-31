package com.yablokovs.leetcode.array.dp;

public class PalindromicSubstring_647 {

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;

        for (int j = 0; j < s.length(); j++) {
            dp[j][j] = true;
            res++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int j = i + 1;
            boolean b = s.charAt(i) == s.charAt(j);
            dp[i][j] = b;
            if (b)
                res++;
        }

        for (int j = 3; j <= s.length(); j++) {
            for (int k = 0; k < s.length() - j + 1; k++) {
                int end = k + j - 1;
                boolean b = checkPali(s, k, end, dp);
                if (b) {
                    res++;
                    dp[k][end] = true;
                }
            }
        }
        return res;
    }

    private boolean checkPali(String s, int l, int r, boolean[][] dp) {

        return s.charAt(l) == s.charAt(r) && dp[l + 1][r - 1];
    }
}
