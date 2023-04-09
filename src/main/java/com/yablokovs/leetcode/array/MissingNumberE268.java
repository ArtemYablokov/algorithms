package com.yablokovs.leetcode.array;

public class MissingNumberE268 {

    /** BIT MANIPIULATION ???
     * -->> XOR
     * */

    public int missingNumberSum(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        int length = nums.length;
        int expectedSum = length * (length + 1) / 2;

        return expectedSum - sum;
    }


    public int missingNumberЧЩК(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ (i + 1);
            result = result ^ nums[i];
        }
        return result;
    }
}
