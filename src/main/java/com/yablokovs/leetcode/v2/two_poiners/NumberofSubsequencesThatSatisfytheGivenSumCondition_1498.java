package com.yablokovs.leetcode.v2.two_poiners;

import java.util.Arrays;

public class NumberofSubsequencesThatSatisfytheGivenSumCondition_1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        double pow = Math.pow(0, 2);
        int i = 0;
        int j = 0;
        int l = nums.length;
        int result = 0;
        while (j < l) {
            // int ni = nums[i];
            // int nj = nums[j];
            while (i < j && nums[i] + nums[j] > target)
                i++;

            if (i <= j && nums[i] + nums[j] <= target) {
                result += (j - i + 1);
            }
            System.out.println(result);
            j++;
        }

        return result;
    }
}

// 3 5 6 7

// 3
// 3 5
// 3 5 6
// 3 6

// 3 5 6 7
// 3 5 7
// 3 6 7
// 3 7

// 5
