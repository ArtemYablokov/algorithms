package com.yablokovs.LC_v3.bt;

public class MaximumRowsCoveredByColumns_2397 {
    int[][] a;
    int h;
    int l;
    int[] counter;

    public int maximumRows(int[][] matrix, int numSelect) {
        a = matrix;
        h = matrix.length;
        l = matrix[0].length;

        // count ones in each row
        // than will decrement each row if one in this column

        counter = new int[h];
        int result = 0;
        for (int i = 0; i < h; i++) {
            int ones = 0;
            for (int j = 0; j < l; j++)
                if (a[i][j] == 1)
                    ones++;
            counter[i] = ones;
            if (ones == 0)
                result++;
        }
        System.out.println(result);
        int max = 0;
        for (int ix = 0; ix <= l - numSelect; ix++) {
            int t = dfs(ix, numSelect, 0);
            if (max < t)
                max = t;
        }

        return result + max;
    }

    // from which column counting
    // left columns to take
    // rows completed
    int dfs(int ix, int left, int rows) {
//        System.out.printf("ix = %d \n", ix);
        if (ix == l) { // if (left == 0)
            return rows;
        }
        int notIncl = 0;

        // can skip cur row ?
        // WHEN available columns after current > left
        int available = l - ix - 1; // available columns after current
        if (left <= available) {
            notIncl = dfs(ix + 1, left, rows);
        }

        // can use ?
        // WHEN left > 0
        int incl = 0;
        if (left > 0) {
            for (int i = 0; i < h; i++) {
                if (a[i][ix] == 1) {
                    counter[i]--;
                    if (counter[i] == 0) {
                        rows++;
                    }
                }
            }
            incl = dfs(ix + 1, left - 1, rows);

            for (int i = 0; i < h; i++) {
                if (a[i][ix] == 1)
                    counter[i]++;
            }
        }

        return Math.max(notIncl, incl);
    }

}
