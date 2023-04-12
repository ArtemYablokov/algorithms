package com.yablokovs.leetcode.array;

public class ValidPalindrome_E_125 {

    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        String r = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int length = r.length();
        int half =  length / 2;

        for (int i = 0; i < half; i++) {
            if (r.charAt(i) != r.charAt(length - i - 1)) return false;
        }

        return true;
    }
}
