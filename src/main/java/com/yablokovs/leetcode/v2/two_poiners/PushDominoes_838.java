package com.yablokovs.leetcode.v2.two_poiners;

public class PushDominoes_838 {
        public String pushDominoes(String dominoes) {
            char[] a = dominoes.toCharArray();
            int l = a.length;
            int i = 0;
            int j = 0;

            while (i < l) {
                while (j < l && a[j] == '.') j++;
                if (j == l) {
                     if (a[i] == 'R')
                        for (int k = i; k < j; k++) a[k] = 'R';
                     break;
                }
                if (a[j] == 'L') {
                    for (int k = i; k < j; k++) a[k] = 'L';
                    i = j + 1;
                    j = j + 1;
                } else { // R
                    i = j;
                    j++;

                    while (j < l && a[j] == '.')  j++;

                    if (j == l) {
                        // fill up R to end
                        for (int k = i; k < j; k++) a[k] = 'R';
                        break;
                    }
                    if (a[j] == 'L') {
                        // fill up R to L
                        int length = j - i + 1;
                        int left = i + length / 2 - 1;
                        for (int k = i; k <= left; k++) a[k] = 'R';
                        int right = j - (length / 2 - 1);
                        for (int k = right; k < j; k++) a[k] = 'L';

                        i = j + 1;
                        j = j + 1;
                    } else { // R
                        // fill with R
                        for (int k = i; k < j; k++) a[k] = 'R';
                        i = j;
                        // j = j + 1;
                    }
                }
            }

            return new String(a);
        }


// 2 . . . 6
// 6 - 2 + 1 = 5 = length
// for L from i to i + length/2 - 1
// for R from j - (length/2 - 1) to j

// R . . R .
}
