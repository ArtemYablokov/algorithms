package com.yablokovs.leetcode.array;

import java.util.List;
import java.util.stream.Collectors;

public class ValidAnagram {

    public static void main(String[] args) {
        boolean anagram = isAnagram("rat", "car");
        int n = 0;
    }

    public static boolean isAnagram(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        int lengths = str1.length;
        int lengtht = str2.length;

        if (lengths != lengtht) {
            return false;
        }

        int[] chars1 = new int[30];
        int[] chars2 = new int[30];

        for (int i = 0; i < lengths; i++) {
            chars1[str1[i] - 'a']++;
            chars2[str2[i] - 'a']++;
        }

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) return false;
        }

        return true;
    }

    public boolean дерьмоЕбаное(String s, String t) {

        List<Character> collect = s.chars().sorted().mapToObj(num -> (char) num).collect(Collectors.toList());
        List<Character> collect2 = t.chars().sorted().mapToObj(num -> (char) num).collect(Collectors.toList());

        return collect.equals(collect2);
    }
}
