package com.yablokovs.LC_v3.dp;

import java.util.Arrays;

public class ShortestCommonSupersequence_1092_V2 {
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
        dp = new int[h + 1][l + 1];

        for (int i = 0; i < h; i++) {
            Arrays.fill(dp[i], -1);
        }

        int len = dfs(0, 0);
        char[] res = new char[l + h - len];
        int i = 0, j = 0;
        int ix = 0;
        while (i < h && j < l) {
            if (c2[i] == c1[j]) {
                res[ix] = c2[i];
                i++;
                j++;
                ix++;
            } else if (dp[i+1][j] < dp[i][j+1]) {
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

// COUNT SAME
    int dfs(int i, int j) {
        if (i == h || j == l)
            return 0;


        if (c1[j] == c2[i]) {
            dp[i][j] = dfs(i + 1, j + 1) + 1;
            return dp[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int skipI = dfs(i + 1, j);
        int skipJ = dfs(i, j + 1);

        dp[i][j] = Math.max(skipI, skipJ);

        return dp[i][j];
    }

}
