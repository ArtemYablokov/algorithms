package com.yablokovs.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence_M_128 {

    public static void main(String[] args) {
        int[] values = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        int solution = solution(values);

        int i = 0;
    }


    private static int solution(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            numbers.add(num);
        }
        Set<Integer> visited = new HashSet<>();

        List<Integer> currentList = new ArrayList<>();
        Iterator<Integer> iterator = numbers.iterator();
        int max = 0;

        while (iterator.hasNext()) {
            int current = iterator.next();
            if (visited.contains(current))
                continue;

            currentList.add(current);
            visited.add(current);

            right(current, numbers, currentList, visited);
            left(current, numbers, currentList, visited);

            max = Math.max(max, currentList.size());
            currentList = new ArrayList<>();

        }
        return max;
    }

    private static void right(int current, Set<Integer> numbers, List<Integer> currentList, Set<Integer> visited) {
        if (numbers.contains(++current)) {
            currentList.add(current);
            visited.add(current);
            right(current, numbers, currentList, visited);
        }
    }

    private static void left(int current, Set<Integer> numbers, List<Integer> currentList, Set<Integer> visited) {
        if (numbers.contains(--current)) {
            currentList.add(current);
            visited.add(current);
            left(current, numbers, currentList, visited);
        }
    }
}
