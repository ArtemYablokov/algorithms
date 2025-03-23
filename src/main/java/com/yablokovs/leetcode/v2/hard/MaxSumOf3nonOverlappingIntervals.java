package com.yablokovs.leetcode.v2.hard;

import java.util.Arrays;

public class MaxSumOf3nonOverlappingIntervals {
    int[] sum;
    int[] a;
    int l;

    int[] response = new int[3];
    int maxSum = 0;

    int[][] memo;
    int k;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        l = nums.length;
        this.k = k;
        a = nums;

        memo = new int[3][l - k + 1];

        sum = new int[l - k + 1]; // 1 2 3 4
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
        // System.out.println(Arrays.toString(sum));

        dfs(0, 0, 0, new int[3]);

        return response;
    }


    private void dfs(int step, int ix, int calculatedSum, int[] indexes) { // step (0 - 2)
        if (step == 3) {
            if (calculatedSum >= this.maxSum) {
                response = Arrays.copyOf(indexes, 3);
                this.maxSum = calculatedSum;
            }

            return;
        }
        if (ix >= l)
            return;

        int curMaxSum = 0;
        int curMaxIndex = -1;
        for (int i = ix; i < l - k + 1; i++) { //  - k * (3 - (step + 1))
            int tempSum = sum[i];
            if (tempSum > curMaxSum || (tempSum == curMaxSum && lexicographocally(curMaxIndex, i))) {

                curMaxSum = tempSum;
                curMaxIndex = i;
                indexes[step] = i;

                dfs(step + 1, i + k, calculatedSum + curMaxSum, indexes);
            }
        }

        // here set memo - because found max sum for cur step

    }

    private boolean lexicographocally(int oldi, int newi) {
        for (int i = 0; i < k; i++) {
            if (a[i + newi] < a[i + oldi])
                return true;
            if (a[i + newi] > a[i + oldi])
                return false;
        }
        return false;
    }


}
