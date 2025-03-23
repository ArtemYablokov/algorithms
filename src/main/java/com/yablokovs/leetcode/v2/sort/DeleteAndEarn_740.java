package com.yablokovs.leetcode.v2.sort;

public class DeleteAndEarn_740 {

    int[] a;
    int result = 0;
    int[] count = new int[(int) 1e5 + 1];
    int[] dp = new int[(int) 1e5 + 1];
    int l = 0;

    public int deleteAndEarn(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (++count[nums[i]] == 1)
                l++;
        }
        if (l == 1)
            return nums[0];

        a = new int[l];

        // put elemets into set
        int ix = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0)
                a[ix++] = i;
        }

        int first = dfs(0);
        int second = 0;
        if (a[1] - 1 == a[0])
            second = dfs(1); // start DFS from 2nd if it's differ from first by 1

        return Math.max(first, second);
    }

    private int dfs(int ix) { // sum, current index
        if (dp[ix] > 0) return dp[ix];
        int cur = a[ix];
        // check dp
        int curSum = cur * count[cur];

        if (ix < l - 3) { // there is 3 left // l - 1 is last element
            if (cur + 1 == a[ix + 1]) { // can't use 1st
                int second = dfs(ix + 2); // go to 2nd
                int third = 0;
                if (a[ix + 2] + 1 == a[ix + 3])  // if 2 & 3 diff by 1 -> go to 3 also
                    third = dfs(ix + 3);
                dp[ix] = curSum + Math.max(second, third);
                return dp[ix];
            } else {
                int first = dfs(ix + 1); // go to 1st
                int second = 0;
                if (a[ix + 1] + 1 == a[ix + 2])  // if 1 & 2 diff by 1 -> go to 2 also
                    second = dfs(ix + 2);
                dp[ix] = curSum + Math.max(first, second);
                return dp[ix];
            }
        }

        if (ix == l - 1) { // last
            return curSum;
        } else if (ix == l - 2) { // pre last
            if (cur + 1 == a[ix + 1])  // cant use last
                return curSum;
            else
                return curSum + dfs(ix + 1); // go to last

        } else { // pre - pre last
            if (cur + 1 != a[ix + 1]) { // can use pre-last
                int first = dfs(ix + 1); // go to pre-last
                int second = 0;
                if (a[ix + 1] + 1 == a[ix + 2])
                    second = dfs(ix + 2); // go to last
                return curSum + Math.max(first, second);
            } else {
                return curSum + dfs(ix + 2); // go to last
            }
        }
    }

}
