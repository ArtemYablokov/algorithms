package com.yablokovs.LC_v3.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfKFreeSubsets_2638_ERROR {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> diffK = new HashSet<>();
        int l = nums.length;

        for(int i = 1; i < l; i++) {
            if (nums[i - 1] + k == nums[i]) {
                diffK.add(nums[i - 1]);
                diffK.add(nums[i]);
            }
        }

        Set<Integer> noDiff = new HashSet<>();
        for (int n : nums) {
            if (!diffK.contains(n)) {
                noDiff.add(n);
            }
        }
        int result = 0;
        int size = noDiff.size();
        int noDiffN = (size + 1) * size / 2;
        result += noDiffN;
        size = diffK.size();
        result += size;

        result += (noDiffN * size);
        result++;



        return result;
    }
}
