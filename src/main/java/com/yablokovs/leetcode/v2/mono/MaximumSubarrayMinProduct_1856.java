package com.yablokovs.leetcode.v2.mono;

import java.util.LinkedList;

public class MaximumSubarrayMinProduct_1856 {
    public int maxSumMinProduct(int[] nums) {
        int l = nums.length;

        int result = nums[0] * nums[0];

        int[] prefix = new int[l];
        int[] min = new int[l];
        int[] dp = new int[l]; // hold max prefixes
        LinkedList<Integer> s = new LinkedList<>(); // indexes
        s.push(-1);
        s.push(0);
        dp[0] = nums[0];
        prefix[0] = nums[0];
        min[0] = nums[0];


        for (int j = 1; j < l; j++) {
            int cur = nums[j];

            while (s.peek() != -1 && nums[s.peek()] >= cur) {
                s.pop();
            }
            int i = s.peek();
            if (i == -1) {
                int t = prefix[j - 1] + cur; // this is the only case when need WHOLE prefix
                // prefix[j] = t;
                dp[j] = t;
                min[j] = cur;
                t *= cur;
                if (t > result) result = t;

                s.push(j);
                prefix[j] = prefix[j - 1] + cur; // on each step - simple prefix
                continue;
            }
            // not reach start
            // if prev element < cur -> take his optimal prefix, dd cur and multiply ???
            // need to store min for prev element
            if (nums[j - 1] < cur) {
                int t = dp[j - 1] + cur; // use optimal prefix

                t *= min[j - 1];
                if (t < cur * cur) { // check if it's better to use only cur number itself
                    min[j] = cur;
                    dp[j] = cur;
                    if (cur * cur > result) result = cur * cur;

                } else {
                    dp[j] = dp[j - 1] + cur;
                    min[j] = min[j - 1];
                    if (t > result) result = t;
                }

                s.push(j);
                prefix[j] = prefix[j - 1] + cur; // on each step - simple prefix
                continue;
            }

        }

        return result;
    }


}
