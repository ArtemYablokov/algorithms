package com.yablokovs.leetcode.dynamic;

public class HouseRobber {


    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int rob = nums[0];
        int notRob = 0;

        int temp;
        for (int i = 1; i < nums.length; i++) {
            temp = rob;
            rob = Math.max(notRob + nums[i], rob);
            notRob = temp;
        }
        return rob;
    }
}
