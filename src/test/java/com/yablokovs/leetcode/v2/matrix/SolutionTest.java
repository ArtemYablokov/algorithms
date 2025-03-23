package com.yablokovs.leetcode.v2.matrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numDistinctIslands() {
        int[][] ints = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int[][] ints2 = {{1,1,1,1},{1,0,1,0},{0,0,0,0},{0,1,1,1},{1,1,0,1}};

        Solution solution = new Solution();
        int i = solution.numDistinctIslands(ints2);
        
    }

    char c = (char) 1029;
    String word = String.valueOf(c);

    char c2 = (char) 1030;
    String letter = String.valueOf(c);

    private void extracted() {
        String s1 = "";
        List<String> strs = new ArrayList<>(List.of(s1, s1));
        StringBuilder sb = new StringBuilder();

        sb.append(word);
        for (String s : strs) {
//            char[] chars = s.toCharArray();
//            for (char ch : chars) {
//                sb.append(ch);
//            }
            sb.append(s);
            sb.append(word);
        }

        String result = sb.toString();

        String s = strs.stream().collect(Collectors.joining(word));

        String[] split = s.split(word);
        List<String> list = Arrays.stream(split).toList();

        int end = 0;
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue() );
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr)
            map.compute(n, (key, v) -> v == null ? 1 : v + 1);

        for (Map.Entry<Integer, Integer> e : map.entrySet() ) pq.offer(e);

        while (k > 0) {
            Map.Entry<Integer, Integer> e = pq.poll();
            int t = e.getValue();
            if (t <= k) {
                k -= t;
            } else {
                break;
            }
        }
        return pq.size();

    }
}