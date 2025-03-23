package com.yablokovs.leetcode.HARD;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l2 > l1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int sum = l1 + l2;
        int half = sum / 2;

        int l = 0;
        int r = l2;

        double res = 0.0;

        while (l <= r) {
            int m2 = (l + r) / 2;
            int m1 = half - m2;

            int left2 = m2 > 0 ? nums2[m2 - 1] : Integer.MIN_VALUE;
            int right2 = m2 < l2 ? nums2[m2] : Integer.MAX_VALUE;

            int left1 = m1 > 0 ? nums1[m1 - 1] : Integer.MIN_VALUE;
            int right1 = m1 < l1 ? nums1[m1] : Integer.MAX_VALUE;

            if (left1 <= right2 && right1 >= left2) {
                if (sum % 2 == 0) {
                    res = ( Math.max(left1, left2) + Math.min(right1, right2) ) / 2.0;
                } else
                    res = Math.min(right1, right2);
                break;
            }
            if (left1 > right2)
                l = m2 + 1;
            else
                r = m2 - 1;
        }

        return res;
    }
}
