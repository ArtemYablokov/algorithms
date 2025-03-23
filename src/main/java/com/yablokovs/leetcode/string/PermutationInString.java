package com.yablokovs.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[128];
        boolean[] bool = new boolean[128];
        for (char c : s1.toCharArray()) {
            map[c] += 1;
            bool[c] = true;
        }

        int start = 0;
        int end = 0;

        int counter = 0;

        char[] arr = s2.toCharArray();

        while (end < arr.length) {
            char cur = arr[end];

            if (bool[cur]) {
                map[cur] -= 1;
                if (map[cur] >= 0)
                    counter++;
                // else counter--;
            }
            end++;
            if (end - start < s1.length())
                continue;
            start++;
            int[][] array = new int[1][1];
            List<int[]> ints = Arrays.stream(array).toList();
//            Collections.sort();
            List<Integer> integers = new ArrayList<>();

            if (counter == s1.length())
                return true;
            while (end < arr.length) {
                char endC = arr[end];
                char startC = arr[start];

                if (bool[endC]) {
                    map[endC] -= 1;
                    if (map[endC] >= 0)
                        counter++;
                } else
                    counter--;

                if (bool[startC]) {
                    map[startC] += 1;
                    if (map[startC] > 0)
                        counter--;
                } else
                    counter++;

                end++;
                start++;

                if (counter == s1.length())
                    return true;
            }

        }

        return false;
    }
}
