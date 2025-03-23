package com.yablokovs.leetcode.HARD.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstring_76Test {

    @Test
    void minWindow() {

        List<Integer> list = new ArrayList<>();
        int size = list.size();
        list.add(null);
        list.add(null);
        list.add(1);
        list.add(null);
        int sizen = list.size();
        list.forEach(System.out::println);
        Integer integer = list.get(0);
        Integer integer2 = list.get(1);
        Integer integer3 = list.get(2);
        Integer integer4 = list.get(3);


        MinimumWindowSubstring_76 minimumWindowSubstring76 = new MinimumWindowSubstring_76();
//        String s = minimumWindowSubstring76.minWindow("zamambcodebanc", "abc");

//        String s2 = minimumWindowSubstring76.minWindow("amamba", "ab");
//        String s3 = minimumWindowSubstring76.minWindow("a", "a");
//        String s3 = minimumWindowSubstring76.minWindow("acb", "ab");
        String s3 = minimumWindowSubstring76.minWindow("a", "b");

        int n = 0;
    }
}