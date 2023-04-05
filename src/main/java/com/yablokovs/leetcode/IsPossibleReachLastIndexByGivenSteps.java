package com.yablokovs.leetcode;

public class IsPossibleReachLastIndexByGivenSteps {
    public static void main(String[] args) {

    }

    private boolean canJump(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);

            if (maxIndex > nums.length - 2) {
                return true;
            }
            if (nums[i] == 0 && maxIndex < i + 1) {
                return false;
            }
        }
        return false;

    }

}
