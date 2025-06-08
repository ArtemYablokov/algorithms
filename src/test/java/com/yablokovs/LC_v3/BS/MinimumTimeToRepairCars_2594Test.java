package com.yablokovs.LC_v3.BS;

import org.junit.jupiter.api.Test;

import static com.yablokovs.LC_v3.util.Util.build;
import static org.junit.jupiter.api.Assertions.*;

class MinimumTimeToRepairCars_2594Test {

    @Test
    void repairCars() {
        MinimumTimeToRepairCars_2594 s = new MinimumTimeToRepairCars_2594();
        long l = s.repairCars(build(4, 2, 3, 1), 10);
    }
}