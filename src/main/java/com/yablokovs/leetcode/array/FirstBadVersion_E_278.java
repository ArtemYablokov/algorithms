package com.yablokovs.leetcode.array;

public class FirstBadVersion_E_278 {

    public int firstBadVersion(int n) {

        int min = 1;
        int max = n;

        while (min <= max) {
//            int mid = (min + max) / 2;
            int mid = min + (max - min) / 2; // to avoid overflow incase (left+right)>2147483647

            if (isBadVersion(mid)) max = mid - 1;
            else min = mid + 1;
        }

        // redundant
//        if (isBadVersion(min)) return min;
//        else return min + 1;

        return min;
    }

    boolean isBadVersion(int version) {
        return false;
    }

}
