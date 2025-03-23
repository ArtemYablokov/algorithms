package com.yablokovs.LC_v3.tree;

import com.yablokovs.LC_v3.util.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeOperations_1993Test {

    @Test
    void test() {
        int[] build = Util.build(-1, 6, 5, 5, 7, 0, 7, 0, 0, 6);
        TreeOperations_1993 t = new TreeOperations_1993(build);
        boolean upgrade1 = t.upgrade(5, 3);
        boolean upgrade2 = t.upgrade(2,3);
        boolean upgrade3 = t.upgrade(7,39);
        boolean upgrade4 = t.upgrade(1,32);

        boolean unlock1 = t.unlock(5, 44);
        boolean unlock2 = t.unlock(2,15);

        boolean upgrade5 = t.upgrade(1,11);
        boolean upgrade6 = t.upgrade(1,18);
        boolean upgrade7 = t.upgrade(3,7);

        boolean lock1 = t.lock(5, 36);
        boolean lock2 = t.lock(5,42);

        boolean upgrade8 = t.upgrade(8,5);
        boolean upgrade9 = t.upgrade(1,19);

        boolean unlock3 = t.unlock(3,38);
         // 5 - 36 L
        boolean upgrade10 = t.upgrade(0,27);
        boolean upgrade11 = t.upgrade(4,11);
        boolean upgrade12 = t.upgrade(9,2);
        boolean upgrade13 = t.upgrade(8,41);

        boolean unlock4 = t.unlock(5, 36);
        boolean unlock5 = t.unlock(7, 29);

        int i = 0;

    }
}