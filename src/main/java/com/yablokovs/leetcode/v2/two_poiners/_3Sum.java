package com.yablokovs.leetcode.v2.two_poiners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < l - 2) {
            int j = i + 1;
            int k = l - 1;
            while (j < k) {
                int t = nums[i] + nums[j] + nums[k];
                if (t == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                }

                if (t > 0) {
                    int nK = nums[k];
                    k--;
                    while (j < k && nums[k] == nK)
                        k--;
                } else {
                    int nJ = nums[j];
                    j++;
                    while (j < k && nums[j] == nJ)
                        j++;
                }
            }
            int nI = nums[i];
            i++;
            while (i < l - 2 && nums[i] == nI)
                i++;
        }

        return result;
    }

}
