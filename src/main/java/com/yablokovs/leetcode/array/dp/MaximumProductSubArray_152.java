package com.yablokovs.leetcode.array.dp;

public class MaximumProductSubArray_152 {

    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[0];


            int temp = max;

            // сравниваются 3 величины:
            max = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(temp * curr, min * curr));

            if (max > ans)
                ans = max;
        }

        return ans;
    }
}
