package com.yablokovs.leetcode.v2.pq;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void topStudents() {

        List<Integer> l = new ArrayList<>();
        l.add(1);
        List<Integer> l2 = new ArrayList<>(l);
        l2.add(2);



        Solution solution = new Solution();
        List<Integer> integers = solution.topStudents(new String[]{"smart", "brilliant", "studious"}, new String[]{"not"}, new String[]{"this student is studious", "the student is smart"}, new int[]{1, 2}, 2);
    }
}