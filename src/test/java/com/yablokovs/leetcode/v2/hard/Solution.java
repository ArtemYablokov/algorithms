package com.yablokovs.leetcode.v2.hard;

import java.util.Arrays;

class Solution {
    int[] sum;
    int[] a;
    int l;

//    int[] response = new int[3];
//    int maxSum = 0;

    Helper[][] memo;

    int k;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        l = nums.length;
        this.k = k;
        a = nums;

        int lengthOfSum = l - k + 1;
        memo = new Helper[3][lengthOfSum];

        sum = new int[lengthOfSum]; // 1 2 3 4
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }
        sum[0] = curSum;

        for (int i = k; i < l; i++) {
            curSum += nums[i];
            curSum -= nums[i - k];
            sum[i - k + 1] = curSum;
        }

        memo[2][l - k] = new Helper(sum[l - k], new int[]{0, 0, l-k});
        for (int i = l - k - 1; i > k * 2 - 1; i--) {
            if (sum[i] >= memo[2][i + 1].sum) {
                memo[2][i] = new Helper(sum[i], new int[]{0, 0, i});
            } else {
                memo[2][i] = memo[2][i + 1];
            }
        }
        // 4 3 2 1
        for (int j = 1; j >= 0; j--) {
            int lastConsidered = lengthOfSum - 1 - k * (2 - j);

            //
            Helper bottomNext = memo[j + 1][lastConsidered + k];
            int[] temp = Arrays.copyOf(bottomNext.a, 3);
            temp[j] = lastConsidered;
            memo[j][lastConsidered] = new Helper(bottomNext.sum + sum[lastConsidered],  temp);

            for (int i = lastConsidered - 1; i >= k * j; i--) {
                bottomNext = memo[j + 1][i + k];

                if (sum[i] + bottomNext.sum >= memo[j][i + 1].sum ) {
                    temp = Arrays.copyOf(bottomNext.a, 3);
                    temp[j] = i;
                    memo[j][i] = new Helper(bottomNext.sum + sum[i],  temp);
                } else {
                    memo[j][i] = memo[j][i + 1];
                }
            }
        }

        return memo[0][0].a;
    }


    class Helper {
        int sum;
        int[] a;

        public Helper(
                int sum,
                int[] a
        ) {
            this.sum = sum;
            this.a = a;
        }
    }

}