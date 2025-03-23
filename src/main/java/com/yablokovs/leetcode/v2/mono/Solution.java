package com.yablokovs.leetcode.v2.mono;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int l = position.length;
        Car[] cars = new Car[l];
        for (int i = 0; i < l; i++) {
            float velocity = (float) (target - position[i]) /  speed[i];
            cars[i] = new Car(position[i], velocity);
        }


        Arrays.sort(cars, Comparator.comparingInt(Car::getPos).reversed());

        LinkedList<Float> ms = new LinkedList<>();

        for (Car c : cars) {
            if (ms.isEmpty() || ms.peek() < c.velocity)
                ms.push(c.velocity);
        }

        return ms.size();
    }

    class Car {
        int pos;
        float velocity;
        public Car (int pos, float velocity) {
            this.pos = pos;
            this.velocity = velocity;
        }
        public int getPos() {
            return this.pos;
        }
    }
}

// speed
// 9 2 2
// position
// 2 4 6
// target = 8

// last car will reach target in 1 sec
// second - in 2 sec
// first - in 1 sec
// thus there will be 2 fleets

// speed
// 9 2 2 2
// position
// 0 1 4 6
// target = 8

// last car will reach target in 1 sec
// third - in 2 sec
// second - in 3 sec
// first - in 1 sec
