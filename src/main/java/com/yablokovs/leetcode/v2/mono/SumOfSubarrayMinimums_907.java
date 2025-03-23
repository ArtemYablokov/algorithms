package com.yablokovs.leetcode.v2.mono;

import java.util.LinkedList;

public class SumOfSubarrayMinimums_907 {

    public int sumSubarrayMins(int[] arr) {
        LinkedList<Integer> s = new LinkedList<>(); // hold indexes

         s.push(-1); // index to count lenght;
        int l = arr.length;
        int[] dp = new int[l];
        int result = 0;
        for (int i = 0; i < l; i++) {
            int cur = arr[i];
//            int j = i - 1;
            while (s.peek() > -1 && arr[s.peek()] > cur) {
                s.pop();
//                j--;
            }


            int sum = 0;
            if (s.peek() > -1) {
                sum += dp[s.peek()];
            }

            sum += (i - s.peek()) * cur;
            dp[i] = sum;
            result += sum;
            s.push(i);
        }

        return result;
    }

}
