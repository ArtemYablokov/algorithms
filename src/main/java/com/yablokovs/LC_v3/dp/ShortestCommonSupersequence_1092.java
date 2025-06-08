package com.yablokovs.LC_v3.dp;

import java.util.Arrays;

public class ShortestCommonSupersequence_1092 {
    int[][] dp;
    int l;
    int h;
    char[] c1;
    char[] c2;
    boolean[] b;

    public String shortestCommonSupersequence(String str1, String str2) {
        c1 = str1.toCharArray();
        c2 = str2.toCharArray();
        l = c1.length;
        h = c2.length;
        b = new boolean[l + h];
        dp = new int[h][l];

        for (int i = 0; i < h; i++) {
            Arrays.fill(dp[i], -1);
        }

        int len = dfs(0, 0);
        char[] res = new char[len];
        int i = 0, j = 0;
        int ix = 0;
        while (i < h && j < l) {
            if (c2[i] == c1[j]) {
                res[ix] = c2[i];
                i++;
                j++;
                ix++;
            } else if (!b[i + j]) {
                res[ix] = c1[j];
                j++;
                ix++;
            } else {
                res[ix] = c2[i];
                i++;
                ix++;
            }
        }

        while (j < l) {
            res[ix] = c1[j];
            j++;
            ix++;
        }
        while (i < h) {
            res[ix] = c2[i];
            i++;
            ix++;
        }

        return new String(res);
    }


    int dfs(int i, int j) {
        if (i == h && j == l)
            return 0;
        if (i == h) {
            return l - j;
        }
        if (j == l) {
            return h - i;
        }

        if (c1[j] == c2[i]) {
            return dfs(i + 1, j + 1) + 1;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        int skipI = dfs(i + 1, j);
        int skipJ = dfs(i, j + 1);

        int t = Math.min(skipI, skipJ) + 1;

        dp[i][j] = t;
        return t;
    }

}
