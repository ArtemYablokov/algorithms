package com.yablokovs.leetcode.v2.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFleet_853Test {

    @Test
    void carFleet() {
        int[] positions = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        CarFleet_853 carFleet853 = new CarFleet_853();
        int i = carFleet853.carFleet(12, positions, speed);
    }
}