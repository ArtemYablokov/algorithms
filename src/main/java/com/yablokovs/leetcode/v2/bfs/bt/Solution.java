package com.yablokovs.leetcode.v2.bfs.bt;

class Solution {
    int[] nums;
    public int maxOperations(int[] nums) {
        this.nums = nums;
        int max = 0;
        int j = nums.length - 1;

        max = Math.max(max, dfs(1, j - 1, nums[0] + nums[j]));
        max = Math.max(max, dfs(2, j, nums[0] + nums[1]));
        max = Math.max(max, dfs(0, j - 2, nums[j - 1] + nums[j]));

        return max;
    }


    private int dfs(int i, int j, int score) {
        if (i >= j) return 1;

        int max = 0;
        if (nums[i] + nums[j] == score)
            max = Math.max(max, dfs(i + 1, j - 1, score));

        if (nums[i] + nums[i + 1] == score)
            max = Math.max(max, dfs(i + 2, j, score));

        if (nums[j] + nums[j - 1] == score)
            max = Math.max(max, dfs(i, j - 2, score));

        return max + 1;
    }
}
