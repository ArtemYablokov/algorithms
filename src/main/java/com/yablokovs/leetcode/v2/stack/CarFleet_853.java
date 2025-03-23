package com.yablokovs.leetcode.v2.stack;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CarFleet_853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int l = speed.length;
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            double distance = target - position[i];
            list.add(new Car(distance / speed[i], (int) distance));
        }
        Collections.sort(list, (a, b) -> Double.compare(a.distance, b.distance));
//        Collections.sort(list, Comparator.comparingDouble(a -> a.distance));


        LinkedList<Double> s = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            double cur = list.get(i).time;
            if (s.isEmpty() || s.peek() < cur)
                s.push(cur);
        }
        return s.size();
    }


    @ToString
    class Car {
        double time;
        int distance;

        public Car(
                double time,
                int distance
        ) {
            this.time = time;
            this.distance = distance;
        }
    }

}
