package com.yablokovs.leetcode.v2.two_poiners;

public class ReduceBinaryRepresentation_1404 {
    public int numSteps(String s) {
        char[] a = s.toCharArray();
        int l = a.length;
        int ix = l - 1;
        int count = 0;

        while (ix > 0) {
            if (a[ix] == '0') {
                count++;
                ix--;
                continue;
            }
            int left = ix - 1;


            count += 2; // add 1
            while (left >= 0 && a[left] == '1') {
                left--;
            }

            if (left == -1) {
                count += (ix - left);
                return count;
            }

            a[left] = '1';
            count += (ix - left - 1);
            ix = left;


        }

        return count;
    }


// 1101
// 1110
// 111
// 1000
// 100
// 10
// 1

// 110010

}
