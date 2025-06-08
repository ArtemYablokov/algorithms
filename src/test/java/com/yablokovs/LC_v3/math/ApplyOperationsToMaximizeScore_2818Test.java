package com.yablokovs.LC_v3.math;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.SortedSet;

import static com.yablokovs.LC_v3.util.Util.build;

class ApplyOperationsToMaximizeScore_2818Test {
    ApplyOperationsToMaximizeScore_2818 solution = new ApplyOperationsToMaximizeScore_2818();
    SortedSet<Integer> primes = solution.getPrimes();

    @Test
    void test1() {

//        int i1 = solution.maximumScore(List.of(1, 2, 3, 4, 5), 2);
//        int i = solution.maximumScore(List.of(8, 3, 9, 3, 8), 2);
//        assert i == 81;
//
//        int i2 = solution.maximumScore(List.of(19, 12, 14, 6, 10, 18), 3);
//        assert i2 == 4788;

        int i3 = solution.maximumScore(List.of(3289, 2832, 14858, 22011), 6);
        assert i3 == 256720975;

    }

    @Test
    void test2() {
        // [3289,2832,14858,22011]
        int[] build = build(3289, 2832, 14858, 22011);
        for (int b : build) {
            int b1 = b;
            System.out.println(solution.getPrimeScore(b1, primes));
        }


        int _12 = solution.getPrimeScore(12, primes); // 2
        int _14 = solution.getPrimeScore(14, primes); // 2
        int _84 = solution.getPrimeScore(84, primes); // 3
        int _60 = solution.getPrimeScore(60, primes); // 3
        int _2310 = solution.getPrimeScore(2310, primes); // 5
    }
}