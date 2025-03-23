package com.yablokovs.leetcode.v2.bit;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int[] arr = new int[32];

        for (int n : nums) {
            for (int i = 0; i <= 31; i++) {
                int right = n & 1;
                n = n >>> 1;
                arr[31 - i] += right;
            }
        }

        // System.out.println(Arrays.toString(arr));
        int l = nums.length / 2;
        int result = 0;
        for (int i = 0; i <= 31; i++) {
            if (arr[31 - i] > l) {
                result |= (1 << i);
            }
        }

        return result;
    }
}
