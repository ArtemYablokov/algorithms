package com.yablokovs.LC_v3.bt;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class PartitionToKEqualSumSubsets_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // each bucket filled will have it's hash of taken elts
        Set<Integer>[] dp = new HashSet[k];
        for (int i = 0; i < k; i++)
            dp[i] = new HashSet<Integer>();

        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum % k > 0)
            return false;
        int size = sum / k;

        return bt(nums, 0, dp, k, 0, 0, size);
    }

    boolean bt(int[] a, int full, Set<Integer>[] dp, int k, int taken, int bucketSize, int size) {
        if (full == k - 1)
            return true;

        for (int i = 0; i < a.length; i++) {
            if ((taken & (1 << i)) > 0)
                continue; // elt already taken

            taken |= (1 << i); // use elt
            if (dp[full].contains(taken)) {
//                taken &= -(1 << i); // remove it
                taken ^= 1 << i;
                continue;
            }
            if (bucketSize + a[i] > size) {
                taken ^= 1 << i;
                continue;
            }

            bucketSize += a[i];
            boolean b;// remove it
            if (bucketSize == size) {
                b = bt(a, full + 1, dp, k, taken, 0, size);

            } else { // when bucketSize not full
                b = bt(a, full, dp, k, taken, bucketSize, size);
            }
            if (b)
                return true;
            dp[full].add(taken);
//            taken &= -(1 << i); // remove it
            taken ^= 1 << i;
            bucketSize -= a[i];
        }

        return false;
    }
}
