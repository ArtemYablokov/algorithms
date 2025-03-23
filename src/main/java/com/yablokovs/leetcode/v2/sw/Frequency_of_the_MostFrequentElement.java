package com.yablokovs.leetcode.v2.sw;

import java.util.Arrays;

public class Frequency_of_the_MostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = nums.length;
        int i = 0;
        int j = 1;

        int max = 1;
        long diff = 0;
        while (j < l) {
            long dist = j - i;
            diff += ( dist * (nums[j] - nums[j - 1]) );

            while (diff > k) {
                diff -= (nums[j] - nums[i++]);
            }
            max = Math.max(max, j - i + 1);
            j++;

        }

        return max;
    }
}
