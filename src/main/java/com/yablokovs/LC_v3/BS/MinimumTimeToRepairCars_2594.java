package com.yablokovs.LC_v3.BS;

public class MinimumTimeToRepairCars_2594 {

    public long repairCars(int[] ranks, int cars) {
        long i = 1;
        long j = Long.MAX_VALUE;

        while (i < j) {
            long m = i + (j - i) / 2;

            int carsCalc = calc(m, ranks, cars);
            if (carsCalc < cars) {
                i = m + 1;
            } else {
                j = m;
            }
        }

        return i;
    }

    int calc(long m, int[] ranks, int cars) {
        // minutes is a limit for reparing for each worker
        // calc how much he can repair in this minutes

        // RANK * CAR * CAR = MINUTES
        // CAR * CAR = MINUTES / RANK
        int carsCalc = 0;
        for (int r : ranks) {
            int t = (int) Math.sqrt(m / r);
            carsCalc += t;
            if (carsCalc >= cars) return carsCalc;
        }
        return carsCalc;
    }
}
