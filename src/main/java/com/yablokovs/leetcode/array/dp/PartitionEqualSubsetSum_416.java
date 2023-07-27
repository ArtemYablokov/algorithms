package com.yablokovs.leetcode.array.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionEqualSubsetSum_416 {

    Boolean mem[][];

    public boolean canPartitionMEMO(int[] nums) {
        int sum = 0;
        int length = nums.length;

        for (int i : nums)
            sum += i;

        if (sum % 2 != 0)
            return false;

        sum /= 2;

        mem = new Boolean[length][sum + 1];

        return subsetSum(nums, 0, sum);
    }

    boolean subsetSum(int[] nums, int index, int target) {
        if (target == 0)
            return true;

        else if (index == nums.length || target < 0)
            return false;

        if (mem[index][target] != null)
            return mem[index][target];

        boolean canReachTarget =
                subsetSum(nums, index + 1, target - nums[index])
                        ||
                        subsetSum(nums, index + 1, target);

        mem[index][target] = canReachTarget;

        return canReachTarget;
    }

    public boolean canPartitionMySet(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        Set<Integer> results = new HashSet<>();
        results.add(0);
        for (int curr : nums) {
            List<Integer> newSum = new ArrayList<>();

            for (Integer result : results) {
                int sumCur = result + curr;
                if (sumCur == target)
                    return true;

                newSum.add(sumCur);
            }

            results.addAll(newSum);
        }
        return false;
    }

    public boolean canPartitionMyDp(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        for (int index = 0; index < nums.length; index++) {
            int current = nums[index];

            List<Integer> newIndexes = new ArrayList<>();
            for (int j = 1; j < dp.length; j++) {
                if (dp[j]) {
                    newIndexes.add(j + current);
                }
            }
            for (int k = 0; k < newIndexes.size(); k++) {
                Integer integer = newIndexes.get(k);
                if (integer < dp.length) {
                    dp[integer] = true;
                }
            }
            if (current < dp.length)
                dp[current] = true;
        }
        return dp[target];
    }

    public boolean canPartitionDp2dimMemo(int[] nums) {

        int length = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0)
            return false;
        sum /= 2;

        boolean[][] dp = new boolean[length + 1][sum + 1];

        for (int index = 0; index <= length; index++) {

            for (int target = 0; target <= sum; target++) {

                if (index == 0 || target == 0)
                    dp[index][target] = false; // all zeros => FALSE ? => means skip ZEROES

                else {
                    int currentNum = nums[index - 1];

                    if (currentNum > target) // use previous value
                        dp[index][target] = dp[index - 1][target];

                    else if (currentNum == target)
                        dp[index][target] = true;

                    else
                        dp[index][target] = dp[index - 1][target] || dp[index - 1][target - currentNum];
                }
            }
            if (dp[index][sum])
                return true;
        }
        return dp[length][sum];
    }


    public boolean canPartitionDp1dimMemo(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int current : nums) {
            for (int target = sum; target > 0; target--) {
                dp[target] = dp[target] || dp[target - current];
            }
            if (dp[sum])
                return true;
        }

        return dp[sum];
    }


}
