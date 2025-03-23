package com.yablokovs.leetcode.v2.two_poiners;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {

        List<List<Integer>> result = new ArrayList<>();

        int[][] a1 = encoded1;
        int[][] a2 = encoded2;
        int l1 = a1.length;
        int l2 = a2.length;
        int i = 0, ii = 1, j = 0, jj = 1;
        int r = 0;

//        List<Integer> temp = new ArrayList<>(List.of(a1[i][0] * a2[j][0] , 1) );
        // temp.add(new ArrayList<>(List.of(a1[i][0] * a2[j][0] , 1)));
        int num = a1[i][0] * a2[j][0];
        int count = 1;

        boolean needAdd = true;
        while (i < l1) {
            if (ii >= a1[i][1]) {
                i++;
                ii = 0;
                continue;
            }
            if (jj >= a2[j][1]) {
                j++;
                jj = 0;
                continue;
            }
            int calc = a1[i][0] * a2[j][0];
            if (num != calc) {
                result.add(List.of(num, count));
                num = calc;
                count = 1;
                r++;
                needAdd = false;
            } else {
                count++;
                needAdd = true;
            }
            ii++; jj++;
        }
        if (needAdd) result.add(List.of(num, count));
        return result;
    }
}