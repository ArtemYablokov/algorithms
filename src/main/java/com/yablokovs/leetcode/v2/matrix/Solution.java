package com.yablokovs.leetcode.v2.matrix;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    int h;
    int l;
    // List<int[]> list = new ArrayList<>();
    int[][] a;
    Set<String> set = new HashSet<>();

    public int numDistinctIslands(int[][] grid) {
        l = grid[0].length;
        h = grid.length;
        a = grid;

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (a[i][j] == 1) {
                    char[] ch = new char[2500];
                    check(i, j, i, j, ch);
                    String temp = new String(ch);
                    if (set.add(temp)) count++;
                }
            }
        }
        System.out.println(set.size());
        return count;
    }
    int[][] moves = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void check(int i, int j, int m, int n, char[] ch) {
        if (m < 0 || n < 0 || m >= h || n >= l || a[m][n] != 1) return;
        a[m][n] = -1;

        ch[l + (m - i) * 2 * l + (l + n - j)] = '1';
        for (int[] move : moves) {
            check(i, j, m + move[0], n + move[1], ch );
        }
    }

}