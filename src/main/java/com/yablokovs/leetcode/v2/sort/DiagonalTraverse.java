package com.yablokovs.leetcode.v2.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {

        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            List<int[]> list = new ArrayList();

            for (int i = 0; i < nums.size(); i++) {
                List<Integer> l = nums.get(i);
                for (int j = 0 ; j < l.size(); j++) {
                    list.add(new int[]{i, j , l.get(j)});
                }
            }

            list.sort((a, b) -> {
                if ((a[0] + a[1]) == (b[0] + b[1]))
                    return Integer.compare(a[1], b[1]);
                else
                    return Integer.compare(a[0] + a[1], b[0] + b[1]);
            });

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) result[i] = list.get(i)[2];

            return result;
        }



}
