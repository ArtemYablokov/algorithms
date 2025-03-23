package com.yablokovs.leetcode.queue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class FindClosestElements2 {
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(Math.abs(x - a), Math.abs(x - b)));

        for (int n : arr) {
            if (pq.size() == k) {
                int cur = pq.peek();
                if (Math.abs(x - cur) == Math.abs(x - n))
                    continue;

                pq.add(n);
                pq.remove();
            } else { // size < k
                pq.add(n);
            }

            // if(pq.size() > k) pq.remove();
        }

        Stack<Integer> s = new Stack<>();
        while (pq.size() > 0) {
            s.push(pq.remove());
        }
        List<Integer> result = new ArrayList<>();
        while (s.size() > 0) {
            result.add(s.pop());
        }
        return result;
        // return pq.stream().toList();
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.remove(1);
        return null;
    }
}
