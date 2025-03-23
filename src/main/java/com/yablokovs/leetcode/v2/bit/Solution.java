package com.yablokovs.leetcode.v2.bit;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int n;
    List<Integer> result = new ArrayList<>();
    public List<Integer> grayCode(int n) {
        this.n = n;
        bt(0, true, 0);

        return result;
        // return List.of(0, 4, 6, 2, 3, 1);
    }

    boolean one = true;
//    boolean zero = false;

    private void bt(int lvl, boolean zero, int cur) {
//        System.out.println(cur);
        if (lvl == n) {
            System.out.println(Integer.toString(cur, 2));
            result.add(cur);
            // result.add(cur & 1<< (n - 1));
            return;
        }
        if (zero) {
            bt(lvl + 1, zero, cur);
            bt(lvl + 1, one, cur | (1 << lvl));
        } else {
            bt(lvl + 1, one, cur | (1 << lvl));
            bt(lvl + 1, zero, cur);
        }
    }
}

// 0 0 0 0
// 1 0 0 0
// 1 1 0 0
// 0 1 0 0

//
//   1 0 0 = 4
//   1 0 1 = 5
//   1 1 1 = 7
// 0 1 1 0 = 6
// 0 0 1 0 = 2
// 0 0 1 1 = 3
// 0 0 0 1 = 1




//   0 0 0
//   0 1 0 = 2
//   0 1 1 = 3
//   1 1 1 = 7
//   1 1 0 = 6
//   1 0 0 = 4
//   1 0 1 = 5
//   0 0 1 = 1