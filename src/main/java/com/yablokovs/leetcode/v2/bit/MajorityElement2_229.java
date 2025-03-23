package com.yablokovs.leetcode.v2.bit;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2_229 {
    public List<Integer> majorityElement(int[] nums) {
        int[] arr = new int[32];

        for (int n : nums) {
            for (int i = 0; i <= 31; i++) {
                int right = n & 1;
                n = n >>> 1;
                arr[31 - i] += right;
            }
        }
        int l = nums.length / 3;


        List<Integer> result = new ArrayList<>();
        for (int n : nums) {
            int t = n;
            boolean b = true;
            for (int i = 0; i <= 31; i++) {
                int right = n & 1;
                n = n >>> 1;
                if (right == 1 && arr[31 - i] <= l) {
                    b = false;
                    break;
                }
            }

            if (b) {
                if (!result.contains(t))
                    result.add(t);
                for (int i = 0; i <= 31; i++) {
                    int right = t & 1;
                    t = t >>> 1;
                    arr[31 - i] -= right;
                }
            }
        }

        return result;

    }

// 5 =  0 1 0 1
// 10 = 1 0 1 0

// result =  1 1 1 1

// 1 1 1 1
// 2 2 2
// 3 3
}
