package com.yablokovs.leetcode.easy;

class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = new String[]{"flower","flow","floight", ""};
        String[] strs2 = new String[]{"dog","racecar","car"};
        String[] strs3 = new String[]{"",""};


        String s = longestCommonPrefix(strs3);
        int n = 0;
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        int pointer = 0;

        while (true) {
            String firstWord = strs[0];
            if (firstWord.length() == pointer) return result.toString();

            char ch = firstWord.charAt(pointer);

            for (int i = 1; i < strs.length; i++) {

                String iWord = strs[i];
                if ((iWord.length() == pointer) || (iWord.charAt(pointer) != ch)) return result.toString();
            }
            result.append(ch);
            pointer++;
        }
    }
}