package com.yablokovs.leetcode.array;

public class LongestPalindrome_E_409 {

    public int longestPalindrome(String s) {
        int[] counter = new int[60];
        for (char c : s.toCharArray()) {
            counter[c - 'A']++;
        }

        int odd = 0;
        int even = 0;
        int i;
        for (i = 0; i < counter.length; i++) {
            int numberOfChar = counter[i];
            even += numberOfChar / 2;
            if (numberOfChar % 2 == 1) { // odd
                odd++;
                break;
            }
        }

        // TODO: 4/15/23 можно инкремент внести в стартовое условие цикла
        i++;
        for (; i < counter.length; i++) {
            int numberOfChar = counter[i];
            even += numberOfChar / 2;
        }
        return odd + even * 2;
    }
}
