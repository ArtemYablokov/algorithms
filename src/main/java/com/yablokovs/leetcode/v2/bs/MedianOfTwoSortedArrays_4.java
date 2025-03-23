package com.yablokovs.leetcode.v2.bs;

public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int l1 = nums1.length;
        int l2 = nums2.length;
        int total = l1 + l2;
        int med = total / 2;

        if (l2 == 0)
            return l1 % 2 == 0 ? (double) (nums1[l1 / 2 - 1] + nums1[l1 / 2]) / 2 : (double) nums1[l1 / 2];

        // int j = l2 / 2; // index in small array
        // int i = med - j;
        // for arrays 2 & 2 it will be 1 and 1
        // for arrays 2 & 1 it will be 0 and 1 (small, large arrays)

        int i = 0;
        int j = l2;

        // while (m >= 0 && m < l2) { // m inside 2nd array bounds -> NO
        // i consider m as right el-t. So it can be == l2
        // that's why j = l2 NOT j = l2 - 1

        while (true) { // EXIT case will be when both pairs are not-decreasing
            int m = (i + j) / 2;
            int leftB = m == 0 ? Integer.MIN_VALUE : nums2[m - 1];
            int rightB = m == l2 ? Integer.MAX_VALUE : nums2[m];

            int up = med - m;
            int leftUp = up == 0 ? Integer.MIN_VALUE : nums1[up - 1];
            int rightUp = up == l1 ? Integer.MAX_VALUE : nums1[up];

            if (leftB <= rightUp && leftUp <= rightB) {
                if (total % 2 == 0) {
                    return (double) (Math.max(leftB, leftUp) + Math.min(rightB, rightUp)) / 2;
                } else {
                    return (double) Math.min(rightB, rightUp); // CHECK !
                }
            } else if (leftB > rightUp) { // move bottom to left
                j = m;
            } else { // || leftUp > rightB
                i = m + 1;
            }
        }
    }


// 1 2 5
// 1 4

// -2 -1
// --  3
}
