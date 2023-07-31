package com.yablokovs.leetcode.array.dp;

public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        int maxLength = 1;
        int[][] holder = new int[1][2];

        for (int i = 0; i < chars.length; i++) {
            int left = i;
            int right = i;

            while (right + 1 < chars.length && chars[right + 1] == chars[i]) {
                right++;
                i++;
            }

            int length = check(left, right, chars, maxLength, holder);
            if (length > maxLength)
                maxLength = length;
        }

        return s.substring(holder[0][0], holder[0][1] + 1);
    }

    private int check(int left, int right, char[] chars, int currentMax, int[][] holder) {
        int currentLength = right - left + 1;

        while (right + 1 < chars.length && left - 1 > -1
                && chars[left - 1] == chars[right + 1]) {

            currentLength += 2;
            right++;
            left--;

        }
        if (currentLength > currentMax) {
            holder[0] = new int[]{left, right};
        }
        return currentLength;
    }

}
