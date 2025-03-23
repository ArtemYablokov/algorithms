package com.yablokovs.leetcode.v2.pq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    Set<String> pos;
    Set<String> neg;
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int l = report.length;
        pos = Arrays.stream(positive_feedback).collect(Collectors.toSet());
        neg = Arrays.stream(negative_feedback).collect(Collectors.toSet());

        PriorityQueue<Student> pq = new PriorityQueue<>( (a, b) ->
                a.balance != b.balance ? a.balance - b.balance : b.id - a.id
        );
        for (int i = 0; i < l; i++) {
            int b = calcBalance(report[i]);

            pq.offer(new Student(b, student_id[i]));
            while (pq.size() > k) pq.poll();
        }
        List<Integer> result = new ArrayList<>(pq.size());
//        pq.forEach(p -> System.out.println(p.id));
        int ix = pq.size() - 1;
//        System.out.println(ix);

        while (ix > -1) {
//            result[ix--] =  pq.poll().id;
            result.add(ix--, pq.poll().id);
        }

        return result;
    }
    private int calcBalance(String report) {
        int b = 0;
        for (String s : report.split("\\s")) {
            if (pos.contains(s)) b += 3;
            else if (neg.contains(s)) b -= 1;
        }
        return b;

    }

    class Student {
        int balance;
        int id;

        public Student(
                int balance,
                int id
        ) {
            this.balance = balance;
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
