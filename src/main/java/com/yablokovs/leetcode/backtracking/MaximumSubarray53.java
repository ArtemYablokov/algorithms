package com.yablokovs.leetcode.backtracking;

public class MaximumSubarray53 {

    public static int maxSubArray(int[] nums) {

        int resultMaxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);

            resultMaxSum = Math.max(resultMaxSum, currentSum);
        }
        return resultMaxSum;
    }

    public static void main(String[] args) {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int n = 0;
    }
}
