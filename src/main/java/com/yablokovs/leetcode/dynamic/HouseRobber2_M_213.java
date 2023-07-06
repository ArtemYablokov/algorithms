package com.yablokovs.leetcode.dynamic;

public class HouseRobber2_M_213 {


    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int notRob1 = 0;
        int rob1 = nums[0];
        int temp1;
        for (int i = 1; i < nums.length - 1; i++) {
            temp1 = rob1;
            rob1 = Math.max(rob1, notRob1 + nums[i]);
            notRob1 = temp1;
        }

        int notRob2 = 0;
        int rob2 = nums[1];
        int temp2;
        for (int i = 2; i < nums.length; i++) {
            temp2 = rob2;
            rob2 = Math.max(rob2, notRob2 + nums[i]);
            notRob2 = temp2;
        }

        return Math.max(rob1, rob2);
    }
}
