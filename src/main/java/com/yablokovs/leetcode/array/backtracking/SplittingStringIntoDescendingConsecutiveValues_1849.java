package com.yablokovs.leetcode.array.backtracking;

public class SplittingStringIntoDescendingConsecutiveValues_1849 {


    public boolean splitString(String s) {
        int[] integers = new int[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            integers[i++] = c - 48;
        }
        i = 0;
        while (i < integers.length && integers[i] == 0) {
            i++;
        }
        long currentNum;
        if (i < integers.length) {
            currentNum = integers[i];
        } else {
            return false; // only zeroes
        }
        for (int j = i + 1; j < integers.length; j++) {
            if (checkString2(integers, j, currentNum, 0, false))
                return true;
            if (String.valueOf(currentNum).length() > 10) continue;
            currentNum = Long.parseLong("" + currentNum + integers[j]);
        }
        return false;
    }


    private boolean checkString2(int[] integers, int nextIndex, long current, long next, boolean isDesc) {
        if (nextIndex == integers.length)
            return isDesc;
        next = Long.parseLong("" + next + integers[nextIndex]);

        if (current - next == 1) {
            if (next == 0) {
                return checkString2(integers, nextIndex + 1, current, 0, true);
            }
            return checkString2(integers, nextIndex + 1, next, 0, true);
        }
        if (next < current) {
            return checkString2(integers, nextIndex + 1, current, next, false);
        }
        return false;
    }
}
