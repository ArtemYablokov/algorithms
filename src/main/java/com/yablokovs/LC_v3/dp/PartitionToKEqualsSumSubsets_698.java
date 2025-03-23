package com.yablokovs.LC_v3.dp;

import java.util.HashSet;
import java.util.Set;

public class PartitionToKEqualsSumSubsets_698 {

    Set<Integer> memo = new HashSet<>();
    int[] a;
    int l;
    int k;
    int target;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        a = nums;
        l = a.length;
        this.k = k;
        int state = 0;

        for (int n : nums)
            target += n;
        if (target % k != 0)
            return false;
        target /= k;

        return dfs(0, 0, 0, target);
    }

    boolean dfs(int ix, int state, int bucket, int sum) {
        if (memo.contains(state))
            return false;
        // if (ix == l) return true;
        if (bucket == k - 1)
            return true;

        for (int i = ix; i < l; i++) {
            if ((1 << i & state) > 0 || sum - a[i] < 0)
                continue;

            state |= 1 << i;
            sum -= a[i];
            boolean b;
            if (sum == 0) {
                b = dfs(0, state, bucket + 1, target);
            } else {
                b = dfs(i + 1, state, bucket, sum);
            }
            if (b)
                return true;
            memo.add(state);
            state ^= 1 << i;
            sum += a[i];
        }

        return false;
    }


}
