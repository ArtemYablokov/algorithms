package com.yablokovs.leetcode.v2.two_poiners;

import java.util.Arrays;

public class TheLatestTimetoCatchaBus_2332 {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int busL = buses.length;
        int pasL = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int p = 0; // passenger's id
        int b = 0; // bus' id


        while (b < busL - 1) {
            int busTime = buses[b];
            int count = 0;
            while (p < pasL && passengers[p] <= busTime) {
                p++;
                count++;
                if (count == capacity)
                    break;
            }
            b++;
        }

        int lastBus = buses[busL - 1];
        // p points to first passanger for last bus
        int firstPassanger = p;


        int count = 0;
        while (p < pasL && passengers[p] <= lastBus) {
            p++;
            count++;
        }

//        if (count < capacity)
//            return lastBus;
        int ix = Math.min(firstPassanger + capacity - 1, pasL - 1);
        int time = passengers[ix];

        while (ix >= 0 && passengers[ix] == time) {
            ix--;
            time--;
        }

        return time;
    }

}
