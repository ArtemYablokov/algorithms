package com.yablokovs.leetcode.v2.bs;

class Solution {
    int[][] mx;
    int h;
    int l;
    public int[] findPeakGrid(int[][] mat) {
        mx = mat;
        h = mx.length;
        l = mx[0].length;

        for (int row = 0; row < h; row++) {
            int[] target = mx[row];
            int i = 0;
            int j = l - 1;
            while (i < j) {
                int m = (i + j) / 2;
                // can check left
                if ( m > 0 ) {
                    if (target[m - 1] > target[m]) j = m;
                    else i = m + 1;
                }
                // can check right
                else if (m < h - 1) {
                    if ( target[m + 1] > target[m] ) i = m + 1;
                    else j = m;
                }
            }
            boolean b = check(row, i);
            if (b) return new int[] {row, i};

        }

        return null;
    }

    int[][] moves = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
    private boolean check(int i, int j) {
        int cur = mx[i][j];
        for (int[] m : moves) {
            int ix = i + m[0];
            int jx = j + m[1];
            if ( ix < 0 || jx < 0 || ix >= h || jx >= l ) continue;
            if (mx[ix][jx] > cur) return false;
        }

        return true;
    }
}