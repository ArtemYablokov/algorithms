package com.yablokovs.leetcode.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SQRTTest {

    @Test
    void mySqrt() {
        int[] ints = {4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9};
        int sum = Arrays.stream(ints).sum();

        SQRT sqrt = new SQRT();
        int i = sqrt.mySqrt(2147483647);
        int n = 0;
    }
}